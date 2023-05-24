-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : dim. 15 mai 2022 à 18:49
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `db_formation`
--

-- --------------------------------------------------------

--
-- Structure de la table `domaine`
--

CREATE TABLE `domaine` (
  `code_domaine` int(11) NOT NULL,
  `Libelle` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `domaine`
--

INSERT INTO `domaine` (`code_domaine`, `Libelle`) VALUES
(1, 'info'),
(2, 'tech'),
(3, 'sc'),
(5, 're'),
(6, 'ffrf');

-- --------------------------------------------------------

--
-- Structure de la table `formateur`
--

CREATE TABLE `formateur` (
  `Code_formateur` int(11) NOT NULL,
  `Nom` varchar(10) NOT NULL,
  `Prenom` varchar(10) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `N_tel` int(11) NOT NULL,
  `Code_organisme` int(11) NOT NULL,
  `code_domaine` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `formateur`
--

INSERT INTO `formateur` (`Code_formateur`, `Nom`, `Prenom`, `Email`, `N_tel`, `Code_organisme`, `code_domaine`) VALUES
(1, 'czcdzc', 'zcdcz', 'czcdzd', 45434567, 2, 2),
(4, 'oicjaijc', 'yikyk', 'gyjty', 88776655, 2, 2),
(6, 'dvsv', 'ffvs', 'svfs', 222, 2, 3),
(7, 'zeze', 'aecfze', 'gnhgn', 222, 2, 2),
(8, 'azdada', 'zezcz', 'zeczzc', 33333322, 2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `formation`
--

CREATE TABLE `formation` (
  `code_formation` int(4) NOT NULL,
  `intitule` varchar(20) NOT NULL,
  `nombre_jour` smallint(6) NOT NULL,
  `annee` int(11) NOT NULL,
  `mois` int(11) NOT NULL,
  `nombre_participant` int(11) NOT NULL,
  `Code_formateur` int(11) NOT NULL,
  `code_domaine` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `formation`
--

INSERT INTO `formation` (`code_formation`, `intitule`, `nombre_jour`, `annee`, `mois`, `nombre_participant`, `Code_formateur`, `code_domaine`) VALUES
(8, 'feegre', 22, 8767, 2, 4, 6, 3),
(9, 'dcaob', 5555, 8877, 7, 5, 4, 3),
(10, 'javafx', 5, 6534, 7, 9, 4, 3);

-- --------------------------------------------------------

--
-- Structure de la table `organisme`
--

CREATE TABLE `organisme` (
  `Code_organisme` int(11) NOT NULL,
  `Libelle` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `organisme`
--

INSERT INTO `organisme` (`Code_organisme`, `Libelle`) VALUES
(1, 'isi'),
(2, 'iset');

-- --------------------------------------------------------

--
-- Structure de la table `participant`
--

CREATE TABLE `participant` (
  `Matricule` int(11) NOT NULL,
  `Nom` varchar(10) NOT NULL,
  `prenom` varchar(10) NOT NULL,
  `date_naissance` date NOT NULL,
  `Code_profil` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `participant`
--

INSERT INTO `participant` (`Matricule`, `Nom`, `prenom`, `date_naissance`, `Code_profil`) VALUES
(9, 'ae', 'd', '2022-05-11', 2);

-- --------------------------------------------------------

--
-- Structure de la table `participation`
--

CREATE TABLE `participation` (
  `Matricule` int(11) NOT NULL,
  `Nom` varchar(10) NOT NULL,
  `code_formation` int(11) NOT NULL,
  `intitule` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `participation`
--

INSERT INTO `participation` (`Matricule`, `Nom`, `code_formation`, `intitule`) VALUES
(9, 'zez', 9, 'dcaob'),
(9, 'zez', 10, 'javafx');

-- --------------------------------------------------------

--
-- Structure de la table `profil`
--

CREATE TABLE `profil` (
  `Code_profil` int(11) NOT NULL,
  `Libelle` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `profil`
--

INSERT INTO `profil` (`Code_profil`, `Libelle`) VALUES
(1, 'tech '),
(2, 'info');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `code_utilisateur` int(11) NOT NULL,
  `login` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `role` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`code_utilisateur`, `login`, `password`, `role`) VALUES
(2, 'aziz', 'aziz', 'admin'),
(4, 'ceac', 'ceazc', 'User'),
(5, 'abir', 'benabid', 'Admin'),
(11, 'user', 'user', 'User'),
(13, 'adzda', 'edd', 'User'),
(14, 'zefzf', 'zezf', 'User');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `domaine`
--
ALTER TABLE `domaine`
  ADD PRIMARY KEY (`code_domaine`);

--
-- Index pour la table `formateur`
--
ALTER TABLE `formateur`
  ADD PRIMARY KEY (`Code_formateur`),
  ADD KEY `a` (`Code_organisme`),
  ADD KEY `b` (`code_domaine`);

--
-- Index pour la table `formation`
--
ALTER TABLE `formation`
  ADD PRIMARY KEY (`code_formation`),
  ADD KEY `c` (`Code_formateur`),
  ADD KEY `d` (`code_domaine`);

--
-- Index pour la table `organisme`
--
ALTER TABLE `organisme`
  ADD PRIMARY KEY (`Code_organisme`);

--
-- Index pour la table `participant`
--
ALTER TABLE `participant`
  ADD PRIMARY KEY (`Matricule`),
  ADD KEY `fd` (`Code_profil`);

--
-- Index pour la table `participation`
--
ALTER TABLE `participation`
  ADD PRIMARY KEY (`Matricule`,`code_formation`),
  ADD KEY `r` (`code_formation`);

--
-- Index pour la table `profil`
--
ALTER TABLE `profil`
  ADD PRIMARY KEY (`Code_profil`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`code_utilisateur`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `domaine`
--
ALTER TABLE `domaine`
  MODIFY `code_domaine` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `formateur`
--
ALTER TABLE `formateur`
  MODIFY `Code_formateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `formation`
--
ALTER TABLE `formation`
  MODIFY `code_formation` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `organisme`
--
ALTER TABLE `organisme`
  MODIFY `Code_organisme` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `participant`
--
ALTER TABLE `participant`
  MODIFY `Matricule` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT pour la table `profil`
--
ALTER TABLE `profil`
  MODIFY `Code_profil` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `code_utilisateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `formateur`
--
ALTER TABLE `formateur`
  ADD CONSTRAINT `a` FOREIGN KEY (`Code_organisme`) REFERENCES `organisme` (`Code_organisme`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `b` FOREIGN KEY (`code_domaine`) REFERENCES `domaine` (`code_domaine`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `formation`
--
ALTER TABLE `formation`
  ADD CONSTRAINT `c` FOREIGN KEY (`Code_formateur`) REFERENCES `formateur` (`Code_formateur`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `d` FOREIGN KEY (`code_domaine`) REFERENCES `domaine` (`code_domaine`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `participant`
--
ALTER TABLE `participant`
  ADD CONSTRAINT `fd` FOREIGN KEY (`Code_profil`) REFERENCES `profil` (`Code_profil`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `participation`
--
ALTER TABLE `participation`
  ADD CONSTRAINT `g` FOREIGN KEY (`Matricule`) REFERENCES `participant` (`Matricule`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `r` FOREIGN KEY (`code_formation`) REFERENCES `formation` (`code_formation`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
