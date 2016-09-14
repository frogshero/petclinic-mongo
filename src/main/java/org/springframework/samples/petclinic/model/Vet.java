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
package org.springframework.samples.petclinic.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.xml.bind.annotation.XmlElement;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Simple JavaBean domain object representing a veterinarian.
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @author Arjen Poutsma
 */
// @Entity
@Document(collection = "vets")
public class Vet extends Person {

	@Transient
	private List<Specialty> specialties;

	public List<Specialty> getSpecialties() {
		if (this.specialties == null) {
			this.specialties = new ArrayList<Specialty>();
		}
		return this.specialties;
	}

	public void setSpecialties(List<Specialty> specialties) {
		this.specialties = specialties;
	}

	@Field("specialtyIds")
	private Set<String> specialtyIds;

	public Set<String> getSpecialtyIds() {
		if (this.specialtyIds == null) {
			this.specialtyIds = new HashSet<>();
		}
		return this.specialtyIds;
	}

	public void setSpecialtyIds(Set<String> specialtyIds) {
		this.specialtyIds = specialtyIds;
	}
	
	@XmlElement
	public List<Specialty> getSpecialties2() {
		List<Specialty> sortedSpecs = new ArrayList<>(getSpecialties());
		PropertyComparator.sort(sortedSpecs, new MutableSortDefinition("name", true, true));
		return Collections.unmodifiableList(sortedSpecs);
	}

	public int getNrOfSpecialties() {
		return getSpecialties().size();
	}

	public void addSpecialty(Specialty specialty) {
		getSpecialties().add(specialty);
	}

}
