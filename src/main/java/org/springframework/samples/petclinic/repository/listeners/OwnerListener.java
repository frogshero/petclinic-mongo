package org.springframework.samples.petclinic.repository.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterConvertEvent;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.repository.PetRepository;
import org.springframework.stereotype.Component;

public class OwnerListener extends AbstractMongoEventListener<Owner> {

	@Autowired
	private PetRepository petRepository;

	@Override
	public void onAfterConvert(AfterConvertEvent<Owner> event) {
		Owner o = event.getSource();
		o.setPets(petRepository.findByOwnerId(o.getId()));
	}
}
