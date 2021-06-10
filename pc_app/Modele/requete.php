<?php

//Connexion a la base de donnee

	try
	{
		//$bdd=new PDO('mysql:host=localhost;dbname=autour2laflamme','root','',array(PDO::MYSQL_ATTR_INIT_COMMAND=>"SET NAMES utf8"));
		$bdd=new PDO('mysql:host=http://phpmyadmin.istic.univ-rennes1.fr/phpmyadmin/;dbname=base_16020326','user_16020326','alijoua',array(PDO::MYSQL_ATTR_INIT_COMMAND=>'SET NAMES utf-8'));
	}
	catch(Exception $e)
	{
		die('Erreur Connexion:'. $e->getMessage());
	}

//Retourne la liste des ARI.

	function listeAri()
	{
		global $bdd;
		$reponse = $bdd->query("SELECT * FROM ARI");
		$donnees = $reponse->fetchALL();
		return $donnees;
	}
	//Retourne la liste des Compresseurs .

	function listComp()
	{
		global $bdd;
		$reponse = $bdd->query("SELECT * FROM compresseurs");
		$donnees = $reponse->fetchALL();
		return $donnees;	
		}
		
		//Retourne la liste des Reparations.

	function listRep()
	{
		global $bdd;
		$reponse = $bdd->query("SELECT * FROM reparations");
		$donnees = $reponse->fetchALL();
		return $donnees;
	}	
		//Retourne la liste des Controles.

	function listContr()
	{
		global $bdd;
		$reponse = $bdd->query("SELECT * FROM controles");
		$donnees = $reponse->fetchALL();
		return $donnees;
	}	
		//Retourne la liste des Elements.

	function listelem()
	{
		global $bdd;
		$reponse = $bdd->query("SELECT * FROM elements");
		$donnees = $reponse->fetchALL();
		return $donnees;
	}

?>
