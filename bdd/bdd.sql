drop schema if exists rattrapage CASCADE;
create schema rattrapage;
set search_path to rattrapage;

CREATE TABLE Responsable(
   id_responsable Serial,
   nom VARCHAR(20) NOT NULL,
   prenom VARCHAR(20) NOT NULL,
   mail VARCHAR(50) NOT NULL,
   password VARCHAR(50) NOT NULL,
   PRIMARY KEY(id_responsable)
);

CREATE TABLE Professeur(
   id_professeur Serial,
   nom VARCHAR(20) NOT NULL,
   prenom VARCHAR(20) NOT NULL,
   mail VARCHAR(50) NOT NULL,
   password VARCHAR(50) NOT NULL,
   PRIMARY KEY(id_professeur)
);

CREATE TABLE Surveillant(
   id_surveillant Serial,
   nom VARCHAR(20) NOT NULL,
   prenom VARCHAR(20) NOT NULL,
   mail VARCHAR(50) NOT NULL,
   password VARCHAR(50) NOT NULL,
   PRIMARY KEY(id_surveillant)
);

CREATE TABLE Eleve(
   id_eleve Serial,
   nom VARCHAR(50) NOT NULL,
   prenom VARCHAR(50) NOT NULL,
   photo VARCHAR(50) NOT NULL,
   PRIMARY KEY(id_eleve)
);

CREATE TABLE Salle(
   id_salle Serial,
   nom_salle VARCHAR(50) NOT NULL,
   nbr_place INT NOT NULL,
   PRIMARY KEY(id_salle)
);

CREATE TABLE Matiere(
   id_matiere Serial,
   code_matiere VARCHAR(50),
   libelle_matiere VARCHAR(50) NOT NULL,
   PRIMARY KEY(id_matiere)
);

CREATE TABLE Rattrapage(
   id_rattrapage Serial,
   sujet VARCHAR(50) NOT NULL,
   date_rattrapage DATE NOT NULL,
   heure_rattrapage TIME,
   duree_rattrapage TIME NOT NULL,
   etat VARCHAR(50) NOT NULL,
   id_professeur INT NOT NULL,
   id_surveillant INT NOT NULL,
   id_salle INT NOT NULL,
   id_matiere INT NOT NULL,
   PRIMARY KEY(id_rattrapage),
   FOREIGN KEY(id_professeur) REFERENCES Professeur(id_professeur),
   FOREIGN KEY(id_surveillant) REFERENCES Surveillant(id_surveillant),
   FOREIGN KEY(id_salle) REFERENCES Salle(id_salle),
   FOREIGN KEY(id_matiere) REFERENCES Matiere(id_matiere)
);

CREATE TABLE Convocation(
   id_eleve Serial,
   id_rattrapage INT,
   note VARCHAR(50) NOT NULL,
   present Boolean NOT NULL,
   heure_rendu TIME,
   PRIMARY KEY(id_eleve, id_rattrapage),
   FOREIGN KEY(id_eleve) REFERENCES Eleve(id_eleve),
   FOREIGN KEY(id_rattrapage) REFERENCES Rattrapage(id_rattrapage)
);

CREATE TABLE Gere(
   id_responsable INT,
   id_rattrapage INT,
   PRIMARY KEY(id_responsable, id_rattrapage),
   FOREIGN KEY(id_responsable) REFERENCES Responsable(id_responsable),
   FOREIGN KEY(id_rattrapage) REFERENCES Rattrapage(id_rattrapage)
);
