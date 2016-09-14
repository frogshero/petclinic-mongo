/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.repository.OwnerRepository;
import org.springframework.samples.petclinic.repository.PetRepository;
import org.springframework.samples.petclinic.repository.VetRepository;
import org.springframework.samples.petclinic.repository.VisitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Mostly used as a facade for all Petclinic controllers Also a placeholder
 * for @Transactional and @Cacheable annotations
 *
 * @author Michael Isvy
 */
@Service
public class ClinicServiceImpl implements ClinicService {

	private PetRepository petRepository;
	private VetRepository vetRepository;
	private OwnerRepository ownerRepository;
	private VisitRepository visitRepository;
	private MongoTemplate mongoTemplate;

	@Autowired
	public ClinicServiceImpl(PetRepository petRepository, VetRepository vetRepository, OwnerRepository ownerRepository,
			VisitRepository visitRepository, MongoTemplate mongoTemplate) {
		this.petRepository = petRepository;
		this.vetRepository = vetRepository;
		this.ownerRepository = ownerRepository;
		this.visitRepository = visitRepository;
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<PetType> findPetTypes() throws DataAccessException {
		return mongoTemplate.findAll(PetType.class, "types");
		// return petTypeRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Owner findOwnerById(String id) throws DataAccessException {
		Owner o = mongoTemplate.findById(id, Owner.class);
		System.out.println(o.getPets().size());
		return o;
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Owner> findOwnerByLastName(String lastName) throws DataAccessException {
		// Like ???????
		Collection<Owner> owners = ownerRepository.findByLastNameLike(lastName);
		// Move to OwnerListenr
		// for (Owner o: owners) {
		// o.setPets(petRepository.findByOwnerId(o.getId()));
		// }
		return owners;
	}

	@Override
	@Transactional
	public void saveOwner(Owner owner) throws DataAccessException {
		ownerRepository.save(owner);

		System.out.println("ssssssssssssssssssssss");
	}

	@Override
	@Transactional
	public void saveVisit(Visit visit) throws DataAccessException {
		visitRepository.save(visit);
	}

	@Override
	@Transactional(readOnly = true)
	public Pet findPetById(String id) throws DataAccessException {
		return petRepository.findOne(id);
	}

	@Override
	@Transactional
	public void savePet(Pet pet) throws DataAccessException {
		petRepository.save(pet);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "vets")
	public Collection<Vet> findVets() throws DataAccessException {
		return vetRepository.findAll();
	}

}
