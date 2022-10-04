--Create database rattrapage
drop schema if exists rattrapage CASCADE;
create schema rattrapage;
set search_path to rattrapage;

CREATE TABLE personne(
   id_personne Serial,
   nom VARCHAR(20) NOT NULL,
   prenom VARCHAR(20) NOT NULL,
   mail VARCHAR(50) UNIQUE NOT NULL,
   password VARCHAR(50) NOT NULL,
   role VARCHAR(50) NOT NULL,
   PRIMARY KEY(id_personne)
);

CREATE TABLE eleve(
   id_eleve Serial,
   nom VARCHAR(50) NOT NULL,
   prenom VARCHAR(50) NOT NULL,
   photo VARCHAR(50) NOT NULL,
   PRIMARY KEY(id_eleve)
);

CREATE TABLE salle(
   id_salle Serial,
   nom VARCHAR(50) NOT NULL,
   nbr_place INT CHECK(nbr_place > 0) NOT NULL,
   PRIMARY KEY(id_salle)
);

CREATE TABLE matiere(
   id_matiere Serial,
   code VARCHAR(50) NOT NULL,
   libelle VARCHAR(50) NOT NULL,
   PRIMARY KEY(id_matiere)
);

CREATE TABLE rattrapage(
   id_rattrapage Serial,
   sujet VARCHAR(50) NOT NULL,
   date DATE NOT NULL,
   heure TIME CHECK(heure >= TIME '08:00:00' AND heure <= TIME '16:00:00') NOT NULL,
   duree INT CHECK(duree >= 60 AND duree <= 240) NOT NULL,
   etat VARCHAR(50) NOT NULL DEFAULT 'Non effectué', 
   id_professeur INT NOT NULL,
   id_surveillant INT NOT NULL,
   id_salle INT NOT NULL,
   id_matiere INT NOT NULL,
   PRIMARY KEY(id_rattrapage),
   FOREIGN KEY(id_professeur) REFERENCES Personne(id_personne),
   FOREIGN KEY(id_surveillant) REFERENCES Personne(id_personne),
   FOREIGN KEY(id_salle) REFERENCES Salle(id_salle),
   FOREIGN KEY(id_matiere) REFERENCES Matiere(id_matiere)
);

CREATE TABLE convocation(
   id_eleve Serial,
   id_rattrapage INT,
   note float CHECK(note >= 0 and note <= 20) NOT NULL DEFAULT 0,
   present Boolean NOT NULL DEFAULT false,
   heure_rendu TIME DEFAULT NULL,
   PRIMARY KEY(id_eleve, id_rattrapage),
   FOREIGN KEY(id_eleve) REFERENCES Eleve(id_eleve),
   FOREIGN KEY(id_rattrapage) REFERENCES Rattrapage(id_rattrapage)
);

INSERT INTO personne(nom, prenom, mail, password, role) values 
   ('Mitterrand', 'François', 'francois.mitterand@ispe.fr', 'francois', 'responsable'),
   ('Bloom', 'Léon', 'leon.bloom@ispe.fr', 'leon', 'responsable'),
   ('Giscard d''Estaing', 'Valéry', 'valery.giscard@ispe.fr', 'valery', 'professeur'),
   ('Chirac', 'Jacques', 'jacques.chirac@ispe.fr', 'jacques', 'professeur'),
   ('Jospin', 'Lionel','lionel.jospin@ispe.fr','lionel', 'professeur'),
   ('De Gaulle', 'Charles', 'charles.degaulle@ispe.fr', 'charles', 'surveillant'),
   ('Pompidou', 'Georges', 'georges.pompidou@ispe.fr', 'georges', 'surveillant'),
   ('Cresson', 'Edith', 'edith.cresson@ispe.fr', 'edith', 'surveillant');

INSERT INTO salle(nom, nbr_place) values
   ('A1', 15),
   ('B2', 10),
   ('C3', 30),
   ('D4', 50),
   ('A2', 20);

INSERT INTO matiere(code, libelle) values
   ('UE1', 'Mathématiques'),
   ('UE2', 'Français'),
   ('UE3', 'Histoire'),
   ('UE1', 'Physique'),
   ('UE2', 'Philosophie'),
   ('UE3', 'Géographie'),
   ('UE4', 'Sport'),
   ('UE4', 'Musique'),
   ('UE2', 'Anglais');

INSERT INTO eleve(nom, prenom, photo) values
   ('Le Gaulois', 'Astérix', 'asterixlegaulois.jpg'),
   ('Luke', 'Lucky', 'luckyluke.jpg'),
   ('Bunny', 'Bugs', 'bugsbunny.jpg'),
   ('Mouse', 'Mickey', 'mickeymouse.jpg'),
   ('Simpson', 'Homer', 'homersimpson.jpg'),
   ('Duck', 'Donald', 'donaldduck.jpg'),
   ('Cat', 'Scat', 'scatcat.jpg'),
   ('Pierrafeu', 'Fred', 'fredpierrafeu.jpg'),
   ('Logre', 'Shrek', 'shreklogre.jpg'),
   ('Dinkley', 'Vera', 'veradinkley.jpg'),
   ('Wayne', 'Bruce', 'brucewayne.jpg'),
   ('Blanc', 'Michel', 'michelblanc.jpg'),
   ('Blanc', 'Gérard', 'gerardblanc.jpg'),
   ('Noir', 'Michel', 'michelnoir.jpg'),
   ('Demonaco', 'Stephanie', 'stephaniedemonaco.jpg');

INSERT INTO rattrapage(sujet, date, heure, duree, etat, id_professeur, id_surveillant, id_salle, id_matiere) values
   ('sujet_math.pdf', '2022-10-24', '10:00:00', 120, 'Effectué et noté', 3, 6, 1, 1),
   ('sujet_physique.pdf', '2022-10-24', '14:00:00', 180, 'Effectué et noté', 4, 7, 4, 4),
   ('sujet_histoire.pdf', '2022-10-25', '14:00:00', 120, 'Effectué mais non noté', 5, 8, 3, 3),
   ('sujet_francais.pdf', '2022-10-25', '08:00:00', 240, 'Non effectué', 3, 6, 2, 2),
   ('sujet_philo.pdf', '2022-10-26', '08:00:00', 120, 'Non effectué', 4, 7, 2, 5),
   ('sujet_geo.pdf', '2022-10-26', '08:00:00', 120, 'Non effectué', 5, 8, 3, 6),
   ('sujet_sport.pdf', '2022-10-27', '08:00:00', 60, 'Non effectué', 3, 6, 4, 7),
   ('sujet_musique.pdf', '2022-10-27', '08:00:00', 60, 'Non effectué', 4, 7, 1, 8),
   ('sujet_anglais.pdf', '2022-10-28', '08:00:00', 60, 'Non effectué', 5, 8, 1, 9);

INSERT INTO convocation(id_eleve, id_rattrapage, note, present, heure_rendu) values
   (1, 1, 10, true, '09:40:00'),
   (3, 1, 12, true, '09:50:00'),
   (5, 1, 14, true, '09:30:00'),
   (7, 1, 16, true, '08:55:00'),
   (9, 1, 0, false, NULL);

INSERT INTO convocation(id_eleve, id_rattrapage, note, present, heure_rendu) values
   (2, 2, 11, true, '09:45:00'),
   (4, 2, 13, true, '09:55:00'),
   (6, 2, 15, true, '09:35:00'),
   (8, 2, 17, true, '09:00:00'),
   (10, 2, 0, false, NULL);

INSERT INTO convocation(id_eleve, id_rattrapage, note, present, heure_rendu) values
   (2, 3, 5, true, '14:58:32'),
   (6, 3, 0, false, NULL),
   (1, 3, 0, true, '15:22:03'),
   (5, 3, 0, true, '15:02:58');

INSERT INTO convocation(id_eleve, id_rattrapage) values
   (4, 4),
   (8, 4),
   (3, 4),
   (7, 4);

INSERT INTO convocation(id_eleve, id_rattrapage) values
   (1, 5),
   (2, 5),
   (3, 5),
   (4, 5),
   (5, 5);

INSERT INTO convocation(id_eleve, id_rattrapage) values
   (6, 6),
   (7, 6),
   (8, 6),
   (9, 6),
   (10, 6);

INSERT INTO convocation(id_eleve, id_rattrapage) values
   (11, 7),
   (12, 7),
   (13, 7),
   (14, 7),
   (15, 7);

INSERT INTO convocation(id_eleve, id_rattrapage) values
   (1, 8),
   (3, 8),
   (7, 8),
   (11, 8),
   (13, 8);

INSERT INTO convocation(id_eleve, id_rattrapage) values
   (2, 9),
   (4, 9),
   (5, 9),
   (10, 9),
   (12, 9);