--Create database rattrapage
drop schema if exists rattrapage CASCADE;
create schema rattrapage;
set search_path to rattrapage;

CREATE TABLE personne(
   id_personne Serial,
   nom VARCHAR(20) NOT NULL,
   prenom VARCHAR(20) NOT NULL,
   mail VARCHAR(50) NOT NULL,
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
   date_rattrapage DATE NOT NULL,
   heure_rattrapage TIME CHECK(heure_rattrapage >= TIME '08:00:00' AND heure_rattrapage <= TIME '16:00:00') NOT NULL,
   duree_rattrapage TIME CHECK(duree_rattrapage >= TIME '01:00:00' AND duree_rattrapage <= TIME '04:00:00') NOT NULL,
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
   note float CHECK(note >= 0 and note <= 20) NOT NULL,
   present Boolean NOT NULL,
   heure_rendu TIME,
   PRIMARY KEY(id_eleve, id_rattrapage),
   FOREIGN KEY(id_eleve) REFERENCES Eleve(id_eleve),
   FOREIGN KEY(id_rattrapage) REFERENCES Rattrapage(id_rattrapage)
);

INSERT INTO personne(nom, prenom, mail, password, role) values 
   ('Mitterrand', 'François', 'francois.mitterand@ispe.fr', 'francois', 'responsable'),
   ('Bloom', 'Léon', 'leon.bloom@ispe.fr', 'Leon', 'responsable'),
   ('Giscard d''Estaing', 'Valéry', 'valery.giscard@ispe.fr', 'valery', 'professeur'),
   ('Chirac', 'Jacques', 'jacques.chirac@ispe.fr', 'jacques', 'professeur'),
   ('Jospin', 'Lionel','lionel.jospin@ispe.fr','lionnel', 'professeur'),
   ('De Gaulle', 'Charles', 'charles.degaulle@ispe.fr', 'charles', 'surveillant'),
   ('Pompidou', 'Georges', 'georges.pompidou@ispe.fr', 'georges', 'surveillant'),
   ('Cresson', 'Edith', 'edith.cresson@ispe.fr', 'edith', 'surveillant');

INSERT INTO salle(nom, nbr_place) values
   ('A1', 15),
   ('B2', 10),
   ('C3', 30),
   ('D4', 18);

INSERT INTO matiere(code, libelle) values
   ('UE1', 'Mathématiques'),
   ('UE2', 'Français'),
   ('UE3', 'Histoire'),
   ('UE4', 'Physique');

INSERT INTO eleve(nom, prenom, photo) values
   ('Le Gaulois', 'Astérix', 'asterixlegaulois.png'),
   ('Luke', 'Lucky', 'luckyluke.png'),
   ('Bunny', 'Bugs', 'bugsbunny.png'),
   ('Mouse', 'Mickey', 'mickeymouse.png'),
   ('Simpson', 'Homer', 'homersimpson.png'),
   ('Duck', 'Donald', 'donaldduck.png'),
   ('Cat', 'Scat', 'scatcat.png'),
   ('Pierrafeu', 'Fred', 'fredpierrafeu.png'),
   ('Logre', 'Shrek', 'shreklogre.png'),
   ('Dinkley', 'Vera', 'veradinkley.png'),
   ('Luxe','Paul','paulluxe.png'),
   ('Blanc','Michel','michelblanc.png'),
   ('Blanc','Gérard','gerardblanc.png'),
   ('Noir','Michel','michelnoir.png'),
   ('Demonaco','Stephanie','stephaniedemonaco');

INSERT INTO rattrapage(sujet, date_rattrapage, heure_rattrapage, duree_rattrapage, id_professeur, id_surveillant, id_salle, id_matiere) values
   ('sujet_math.pdf', '11/09/2022', TIME '10:00:00', TIME '02:00:00', 3, 6, 1, 1),
   ('sujet_francais.pdf', '12/09/2022', TIME '08:00:00', TIME '04:00:00', 4, 7, 2, 2);

INSERT INTO convocation(id_eleve, id_rattrapage, note, present, heure_rendu) values
   (1, 1, 10, true, '09:40:00'),
   (2, 2, 11, true, '09:45:00'),
   (3, 1, 12, true, '09:50:00'),
   (4, 2, 13, true, '09:55:00'),
   (5, 1, 14, true, '09:30:00'),
   (6, 2, 15, true, '09:35:00'),
   (7, 1, 16, true, '08:55:00'),
   (8, 2, 17, true, '09:00:00'),
   (9, 1, 0, false, NULL),
   (10, 2, 0, false, NULL);
