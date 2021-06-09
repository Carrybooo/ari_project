-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 09 juin 2021 à 14:23
-- Version du serveur :  8.0.21
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `poseidon`
--

-- --------------------------------------------------------

--
-- Structure de la table `ari`
--

DROP TABLE IF EXISTS `ari`;
CREATE TABLE IF NOT EXISTS `ari` (
  `ID` text NOT NULL,
  `Etat Gonflage` tinyint(1) NOT NULL,
  `Lieu de stock` text NOT NULL,
  `Réparation` date DEFAULT NULL,
  `Contrôle` date DEFAULT NULL,
  `Utilisation` tinyint(1) NOT NULL,
  `Vehicule` text
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='Table recensant tous les ARI / dernier controle / reparation';

--
-- Déchargement des données de la table `ari`
--

INSERT INTO `ari` (`ID`, `Etat Gonflage`, `Lieu de stock`, `Réparation`, `Contrôle`, `Utilisation`, `Vehicule`) VALUES
('ARI10', 0, 'CS10', '2021-06-09', '2021-06-09', 1, NULL),
('ARI11', 0, 'CS10', '2021-06-09', '2021-06-09', 0, NULL),
('ARI12', 0, 'CS10', '2021-06-09', '2021-06-09', 0, 'V10'),
('ARI14', 0, 'CS12', NULL, NULL, 1, 'V12');

-- --------------------------------------------------------

--
-- Structure de la table `compresseurs`
--

DROP TABLE IF EXISTS `compresseurs`;
CREATE TABLE IF NOT EXISTS `compresseurs` (
  `ID` text NOT NULL,
  `Fonctionnel` tinyint(1) NOT NULL,
  `Lieu de stock` text NOT NULL,
  `Réparation` date DEFAULT NULL,
  `Contrôles` date DEFAULT NULL,
  `Utilisation` tinyint(1) NOT NULL,
  `Vehicule` text
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='Recensement des compresseurs / dernier controle / reparation';

--
-- Déchargement des données de la table `compresseurs`
--

INSERT INTO `compresseurs` (`ID`, `Fonctionnel`, `Lieu de stock`, `Réparation`, `Contrôles`, `Utilisation`, `Vehicule`) VALUES
('CP10', 0, 'CS11', NULL, NULL, 1, NULL),
('CP11', 0, 'CS12', NULL, '0000-00-00', 1, NULL),
('CP12', 0, 'CS13', NULL, '2021-06-09', 1, 'V12');

-- --------------------------------------------------------

--
-- Structure de la table `controlehistorique`
--

DROP TABLE IF EXISTS `controlehistorique`;
CREATE TABLE IF NOT EXISTS `controlehistorique` (
  `ID` text NOT NULL,
  `Date` date NOT NULL,
  `Executeur` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `controlehistorique`
--

INSERT INTO `controlehistorique` (`ID`, `Date`, `Executeur`) VALUES
('ARI13', '2021-06-02', 'bramone'),
('CP12', '2021-06-03', 'bramone');

-- --------------------------------------------------------

--
-- Structure de la table `controleprevu`
--

DROP TABLE IF EXISTS `controleprevu`;
CREATE TABLE IF NOT EXISTS `controleprevu` (
  `ID` text NOT NULL,
  `Date` date NOT NULL,
  `Executeur` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `controleprevu`
--

INSERT INTO `controleprevu` (`ID`, `Date`, `Executeur`) VALUES
('CP11', '2021-06-22', 'bramone'),
('ARI13', '2021-06-24', 'bramone'),
('ARI10', '2021-06-27', 'bramone');

-- --------------------------------------------------------

--
-- Structure de la table `elements`
--

DROP TABLE IF EXISTS `elements`;
CREATE TABLE IF NOT EXISTS `elements` (
  `Materiel` text NOT NULL,
  `ID` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='Table recensant tout le matériel';

--
-- Déchargement des données de la table `elements`
--

INSERT INTO `elements` (`Materiel`, `ID`) VALUES
('ARI', 'ARI10'),
('ARI', 'ARI11'),
('ARI', 'ARI12'),
('ARI', 'ARI13'),
('Compresseur', 'CP10'),
('Compresseur', 'CP11'),
('Compresseur', 'CP12'),
('Compresseur', 'CP13'),
('Centre', 'CS10'),
('Centre', 'CS12'),
('Centre', 'CS11'),
('Centre', 'CS13'),
('Vehicule', 'V10'),
('Vehicule', 'V11'),
('Vehicule', 'V12'),
('Vehicule', 'V13');

-- --------------------------------------------------------

--
-- Structure de la table `historiquerepa`
--

DROP TABLE IF EXISTS `historiquerepa`;
CREATE TABLE IF NOT EXISTS `historiquerepa` (
  `ID` text NOT NULL,
  `Date` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `historiquerepa`
--

INSERT INTO `historiquerepa` (`ID`, `Date`) VALUES
('ARI11', '2021-06-01'),
('ARI13', '2021-06-05'),
('ARI12', '2021-06-09');

-- --------------------------------------------------------

--
-- Structure de la table `repaencours`
--

DROP TABLE IF EXISTS `repaencours`;
CREATE TABLE IF NOT EXISTS `repaencours` (
  `ID` text NOT NULL,
  `Lieu de stock` text NOT NULL,
  `Executeur` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='Table des réparations en cours';

-- --------------------------------------------------------

--
-- Structure de la table `repaprevuee`
--

DROP TABLE IF EXISTS `repaprevuee`;
CREATE TABLE IF NOT EXISTS `repaprevuee` (
  `ID` text NOT NULL,
  `Executeur` text NOT NULL,
  `Lieu` text NOT NULL,
  `Date` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `reparations`
--

DROP TABLE IF EXISTS `reparations`;
CREATE TABLE IF NOT EXISTS `reparations` (
  `ID` text NOT NULL,
  `En demande` tinyint(1) NOT NULL,
  `Prévue` tinyint(1) NOT NULL,
  `En cours` tinyint(1) NOT NULL,
  `Terminée` tinyint(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='Table recensant toutes les réparations';

--
-- Déchargement des données de la table `reparations`
--

INSERT INTO `reparations` (`ID`, `En demande`, `Prévue`, `En cours`, `Terminée`) VALUES
('ARI14', 1, 1, 1, 0),
('ARI13', 1, 1, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

DROP TABLE IF EXISTS `utilisateurs`;
CREATE TABLE IF NOT EXISTS `utilisateurs` (
  `Identifiant` text NOT NULL,
  `Password` text NOT NULL,
  `Admin` tinyint(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `utilisateurs`
--

INSERT INTO `utilisateurs` (`Identifiant`, `Password`, `Admin`) VALUES
('bramone', 'bramonekek', 0),
('ajoua', 'ajoualel', 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
