-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 24 juin 2021 à 11:41
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
  `id` text NOT NULL,
  `etat_gonflage` tinyint(1) NOT NULL,
  `lieu_stock` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='Table recensant tous les ARI / dernier controle / reparation';

--
-- Déchargement des données de la table `ari`
--

INSERT INTO `ari` (`id`, `etat_gonflage`, `lieu_stock`) VALUES
('ARI1', 1, 'CS1'),
('ARI2', 0, 'CS1'),
('ARI3', 1, 'CS2');

-- --------------------------------------------------------

--
-- Structure de la table `compresseurs`
--

DROP TABLE IF EXISTS `compresseurs`;
CREATE TABLE IF NOT EXISTS `compresseurs` (
  `id` text NOT NULL,
  `fonctionnel` tinyint(1) NOT NULL,
  `lieu_stock` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='Recensement des compresseurs / dernier controle / reparation';

--
-- Déchargement des données de la table `compresseurs`
--

INSERT INTO `compresseurs` (`id`, `fonctionnel`, `lieu_stock`) VALUES
('CP1', 1, 'CS1'),
('CP2', 0, 'CS2'),
('CP3', 1, 'CS2');

-- --------------------------------------------------------

--
-- Structure de la table `controlehistorique`
--

DROP TABLE IF EXISTS `controlehistorique`;
CREATE TABLE IF NOT EXISTS `controlehistorique` (
  `id` text NOT NULL,
  `date` date NOT NULL,
  `executeur` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `controlehistorique`
--

INSERT INTO `controlehistorique` (`id`, `date`, `executeur`) VALUES
('ARI1', '2021-06-23', 'bramone'),
('ARI1', '2021-06-16', 'bramone'),
('ARI1', '2021-05-18', 'bramone'),
('ARI1', '2021-05-11', 'bramone'),
('ARI1', '2021-04-21', 'bramone'),
('ARI2', '2021-04-27', 'ajoua'),
('ARI2', '2021-05-12', 'ajoua'),
('ARI2', '2021-05-25', 'ajoua'),
('ARI2', '2021-06-09', 'ajoua'),
('ARI2', '2021-06-23', 'ajoua'),
('ARI3', '2021-06-22', 'bramone'),
('ARI3', '2021-06-14', 'bramone'),
('ARI3', '2021-05-31', 'bramone'),
('ARI3', '2021-05-19', 'bramone'),
('ARI3', '2021-04-20', 'bramone');

-- --------------------------------------------------------

--
-- Structure de la table `controleprevu`
--

DROP TABLE IF EXISTS `controleprevu`;
CREATE TABLE IF NOT EXISTS `controleprevu` (
  `id` text NOT NULL,
  `date` date NOT NULL,
  `executeur` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `historiquegonflage`
--

DROP TABLE IF EXISTS `historiquegonflage`;
CREATE TABLE IF NOT EXISTS `historiquegonflage` (
  `ari` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `date` date NOT NULL,
  `lieu` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `compresseur` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `historiquegonflage`
--

INSERT INTO `historiquegonflage` (`ari`, `date`, `lieu`, `compresseur`) VALUES
('ARI1', '2021-06-21', 'CS1', 'CP1'),
('ARI1', '2021-06-09', 'CS1', 'CP1'),
('ARI1', '2021-05-26', 'CS2', 'CP2'),
('ARI1', '2021-05-17', 'CS1', 'CP1'),
('ARI2', '2021-06-21', 'CS1', 'CP1'),
('ARI2', '2021-06-10', 'CS1', 'CP1'),
('ARI2', '2021-05-05', 'CS2', 'CP2'),
('ARI2', '2021-04-28', 'CS2', 'CP2'),
('ARI2', '2021-04-19', 'CS2', 'CP2'),
('ARI3', '2021-06-21', 'CS1', 'CP1'),
('ARI3', '2021-06-14', 'CS1', 'CP1'),
('ARI3', '2021-05-25', 'CS2', 'CP2'),
('ARI3', '2021-05-12', 'CS2', 'CP2'),
('ARI3', '2021-04-28', 'CS2', 'CP2');

-- --------------------------------------------------------

--
-- Structure de la table `historiquerepa`
--

DROP TABLE IF EXISTS `historiquerepa`;
CREATE TABLE IF NOT EXISTS `historiquerepa` (
  `id` text NOT NULL,
  `date` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `historiquerepa`
--

INSERT INTO `historiquerepa` (`id`, `date`) VALUES
('ARI1', '2021-06-22'),
('ARI1', '2021-06-16'),
('ARI1', '2021-05-25'),
('ARI1', '2021-05-11'),
('ARI1', '2021-04-27'),
('ARI2', '2021-06-14'),
('ARI2', '2021-06-05'),
('ARI2', '2021-05-18'),
('ARI2', '2021-05-05'),
('ARI2', '2021-04-19'),
('ARI2', '2021-06-19'),
('ARI3', '2021-06-10'),
('ARI3', '2021-05-24'),
('ARI3', '2021-05-13'),
('ARI3', '2021-04-07');

-- --------------------------------------------------------

--
-- Structure de la table `repaencours`
--

DROP TABLE IF EXISTS `repaencours`;
CREATE TABLE IF NOT EXISTS `repaencours` (
  `id` text NOT NULL,
  `lieu_stock` text NOT NULL,
  `executeur` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='Table des reparations en cours';

-- --------------------------------------------------------

--
-- Structure de la table `repaprevu`
--

DROP TABLE IF EXISTS `repaprevu`;
CREATE TABLE IF NOT EXISTS `repaprevu` (
  `id` text NOT NULL,
  `executeur` text NOT NULL,
  `lieu` text NOT NULL,
  `date` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `reparations`
--

DROP TABLE IF EXISTS `reparations`;
CREATE TABLE IF NOT EXISTS `reparations` (
  `id` text NOT NULL,
  `en_demande` tinyint(1) NOT NULL,
  `prevue` tinyint(1) NOT NULL,
  `en_cours` tinyint(1) NOT NULL,
  `terminee` tinyint(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='Table recensant toutes les reparations';

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

DROP TABLE IF EXISTS `utilisateurs`;
CREATE TABLE IF NOT EXISTS `utilisateurs` (
  `identifiant` text NOT NULL,
  `password` text NOT NULL,
  `Admin` tinyint(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
