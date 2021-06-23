-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 22 juin 2021 à 14:59
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
('ARI10', 0, 'CS10'),
('ARI11', 0, 'CS10'),
('ARI12', 0, 'CS10'),
('ARI14', 0, 'CS12');

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
('CP10', 0, 'CS11'),
('CP11', 0, 'CS12'),
('CP12', 0, 'CS13');

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
('ARI13', '2021-06-02', 'bramone'),
('CP12', '2021-06-03', 'bramone');

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

--
-- Déchargement des données de la table `controleprevu`
--

INSERT INTO `controleprevu` (`id`, `date`, `executeur`) VALUES
('CP11', '2021-06-22', 'bramone'),
('ARI13', '2021-06-24', 'bramone'),
('ARI10', '2021-06-27', 'bramone');

-- --------------------------------------------------------

--
-- Structure de la table `elements`
--

DROP TABLE IF EXISTS `elements`;
CREATE TABLE IF NOT EXISTS `elements` (
  `materiel` text NOT NULL,
  `id` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='Table recensant tout le matériel';

--
-- Déchargement des données de la table `elements`
--

INSERT INTO `elements` (`materiel`, `id`) VALUES
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
('vehicule', 'V10'),
('vehicule', 'V11'),
('vehicule', 'V12'),
('vehicule', 'V13');

-- --------------------------------------------------------

--
-- Structure de la table `historiquegonflage`
--

DROP TABLE IF EXISTS `historiquegonflage`;
CREATE TABLE IF NOT EXISTS `historiquegonflage` (
  `id` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `date` date NOT NULL,
  `lieu` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `compresseur` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
('ARI11', '2021-06-01'),
('ARI13', '2021-06-05'),
('ARI12', '2021-06-09');

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

--
-- Déchargement des données de la table `reparations`
--

INSERT INTO `reparations` (`id`, `en_demande`, `prevue`, `en_cours`, `terminee`) VALUES
('ARI14', 1, 1, 1, 0),
('ARI13', 1, 1, 0, 0);

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

--
-- Déchargement des données de la table `utilisateurs`
--

INSERT INTO `utilisateurs` (`identifiant`, `password`, `Admin`) VALUES
('bramone', 'bramonekek', 0),
('ajoua', 'ajoualel', 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
