-- Inserting data into tables --
INSERT INTO drone(update_date_time,create_date_time,serial_no,model,state,battery_capacity,weight_limit) VALUES (current_timestamp,current_timestamp,'12KWLM',1,0,12,24);    
INSERT INTO drone(update_date_time,create_date_time,serial_no,model,state,battery_capacity,weight_limit) VALUES (current_timestamp,current_timestamp,'188PUIK',2,2,24,25);
INSERT INTO drone(update_date_time,create_date_time,serial_no,model,state,battery_capacity,weight_limit) VALUES (current_timestamp,current_timestamp,'500YTLM',3,0,23,28);
INSERT INTO drone(update_date_time,create_date_time,serial_no,model,state,battery_capacity,weight_limit) VALUES (current_timestamp,current_timestamp,'234YTE',3,1,10,30);
INSERT INTO drone(update_date_time,create_date_time,serial_no,model,state,battery_capacity,weight_limit) VALUES (current_timestamp,current_timestamp,'990WTR',2,3,18,50);
INSERT INTO drone(update_date_time,create_date_time,serial_no,model,state,battery_capacity,weight_limit) VALUES (current_timestamp,current_timestamp,'156KHG',0,3,54,100);
INSERT INTO drone(update_date_time,create_date_time,serial_no,model,state,battery_capacity,weight_limit) VALUES (current_timestamp,current_timestamp,'989KIM',2,2,100,500);

INSERT INTO medication(update_date_time,create_date_time,code,name,image,weight) VALUES (current_timestamp,current_timestamp,'TWU143','PANADOL','HHJHJHJ',24);
INSERT INTO medication(update_date_time,create_date_time,code,name,image,weight) VALUES (current_timestamp,current_timestamp,'REW978','DISPERIN','HHJHJHJ',50);
INSERT INTO medication(update_date_time,create_date_time,code,name,image,weight) VALUES (current_timestamp,current_timestamp,'LOY684','AMOXIL','HHJHJHJ',90);
INSERT INTO medication(update_date_time,create_date_time,code,name,image,weight) VALUES (current_timestamp,current_timestamp,'QWE256','BRUFEN','HHJHJHJ',70);
INSERT INTO medication(update_date_time,create_date_time,code,name,image,weight) VALUES (current_timestamp,current_timestamp,'MBC967','ALP','HHJHJHJ',4);
INSERT INTO medication(update_date_time,create_date_time,code,name,image,weight) VALUES (current_timestamp,current_timestamp,'JGL945','CERBEX Z','HHJHJHJ',12);

INSERT INTO loaded_medication(update_date_time,create_date_time,is_active,drone_id,medication_id) VALUES(current_timestamp,current_timestamp,1,2,5)
