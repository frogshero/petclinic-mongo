package org.springframework.samples.petclinic.repository.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterConvertEvent;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.samples.petclinic.model.Specialty;
import org.springframework.samples.petclinic.model.Vet;

public class VetListener extends AbstractMongoEventListener<Vet> {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void onAfterConvert(AfterConvertEvent<Vet> event) {
		Vet v = event.getSource();
		if (v.getSpecialtyIds().size() > 0) {
			v.setSpecialties(
					mongoTemplate.find(new Query(Criteria.where("id").in(v.getSpecialtyIds())), Specialty.class));
		}
	}
}
