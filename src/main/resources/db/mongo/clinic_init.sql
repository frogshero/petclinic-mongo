db.owners.remove({});
db.vets.remove({});
db.pets.remove({});
db.types.remove({});
db.visits.remove({});
db.specialties.remove({});
db.vet_specialties.remove({});

db.owners.insert([{_id:'1', first_name:'George', last_name:'Franklin', address:'110 W. Liberty St.', city:'Madison', telephone:'6085551023'},
{_id:'2', first_name:'Betty', last_name:'Davis', address:'638 Cardinal Ave.', city:'Sun Prairie', telephone:'6085551749'},
{_id:'3', first_name:'Eduardo', last_name:'Rodriquez', address:'2693 Commerce St.', city:'McFarland', telephone:'6085558763'},
{_id:'4', first_name:'Harold', last_name:'Davis', address:'563 Friendly St.', city:'Windsor', telephone:'6085553198'},
{_id:'5', first_name:'Peter', last_name:'McTavish', address:'2387 S. Fair Way', city:'Madison', telephone:'6085552765'},
{_id:'6', first_name:'Jean', last_name:'Coleman', address:'105 N. Lake St.', city:'Monona', telephone:'6085552654'},
{_id:'7', first_name:'Jeff', last_name:'Black', address:'1450 Oak Blvd.', city:'Monona', telephone:'6085555387'},
{_id:'8', first_name:'Maria', last_name:'Escobito', address:'345 Maple St.', city:'Madison', telephone:'6085557683'},
{_id:'9', first_name:'David', last_name:'Schroeder', address:'2749 Blackhawk Trail', city:'Madison', telephone:'6085559435'},
{_id:'10', first_name:'Carlos', last_name:'Estaban', address:'2335 Independence La.', city:'Waunakee', telephone:'6085555487'}]);

db.pets.insert([
{_id:'1', name:'Leo', birthDate:'2000-09-07', type_id:'1', owner_id:'1'},
{_id:'2', name:'Basil', birthDate:'2002-08-06', type_id:'6', owner_id:'2'},
{_id:'3', name:'Rosy', birthDate:'2001-04-17', type_id:'2', owner_id:'3'},
{_id:'4', name:'Jewel', birthDate:'2000-03-07', type_id:'2', owner_id:'3'},
{_id:'5', name:'Iggy', birthDate:'2000-11-30', type_id:'3', owner_id:'4'},
{_id:'6', name:'George', birthDate:'2000-01-20', type_id:'4', owner_id:'5'},
{_id:'7', name:'Samantha', birthDate:'1995-09-04', type_id:'1', owner_id:'6'},
{_id:'8', name:'Max', birthDate:'1995-09-04', type_id:'1', owner_id:'6'},
{_id:'9', name:'Lucky', birthDate:'1999-08-06', type_id:'5', owner_id:'7'},
{_id:'10', name:'Mulligan', birthDate:'1997-02-24', type_id:'2', owner_id:'8'},
{_id:'11', name:'Freddy', birthDate:'2000-03-09', type_id:'5', owner_id:'9'},
{_id:'12', name:'Lucky', birthDate:'2000-06-24', type_id:'2', owner_id:'10'},
{_id:'13', name:'Sly', birthDate:'2002-06-08', type_id:'1', owner_id:'10'}]);

db.types.insert([
{_id:'1', name:'cat'},
{_id:'2', name:'dog'},
{_id:'3', name:'lizard'},
{_id:'4', name:'snake'},
{_id:'5', name:'bird'},
{_id:'6', name:'hamster'}
]);

db.visits.insert([
{_id:'1', pet_id:'7',visit_date:'2010-03-04', description:'rabies shot'},
{_id:'2', pet_id:'8',visit_date:'2011-03-04', description:'rabies shot'},
{_id:'3', pet_id:'8',visit_date:'2009-06-04', description:'neutered'},
{_id:'4', pet_id:'7',visit_date:'2008-09-04', description:'spayed'}
]);

db.specialties.insert([
{_id:'1', name:'radiology'},
{_id:'2', name:'surgery'},
{_id:'3', name:'dentistry'}
]);

db.vets.insert([{_id:'1', first_name:'James', last_name:'Carter'},
{_id:'2', first_name:'Helen', last_name:'Leary', specialtyIds:['1']},
{_id:'3', first_name:'Linda', last_name:'Douglas', specialtyIds:['2', '3']},
{_id:'4', first_name:'Rafael', last_name:'Ortega', specialtyIds:['2']},
{_id:'5', first_name:'Henry', last_name:'Stevens', specialtyIds:['1']},
{_id:'6', first_name:'Sharon', last_name:'Jenkins'}]);

db.vet_specialties.insert([
{vet_id:'2', specialty_id:'1'},
{vet_id:'3', specialty_id:'2'},
{vet_id:'3', specialty_id:'3'},
{vet_id:'4', specialty_id:'2'},
{vet_id:'5', specialty_id:'1'}
]);