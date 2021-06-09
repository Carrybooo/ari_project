<?php
//session_start();
include_once('../Modele/requete.php');
//les lignes éditoriales
$_SESSION['lign']=ligne();
if (!empty($_SESSION['lign']))
{
	foreach($_SESSION['lign'] as $cle => $element)
	{
		$_SESSION['lign'][$cle]['idLig']=htmlspecialchars($element['idLig']);
		$_SESSION['lign'][$cle]['nom']=htmlspecialchars($element['nom']);
		$_SESSION['lign'][$cle]['description']=htmlspecialchars($element['description']);
	}
}
//journalistes
$_SESSION['journ']=journaliste();
if (!empty($_SESSION['journ']))
{
	foreach($_SESSION['journ'] as $cle => $element)
	{
		$_SESSION['journ'][$cle]['idJo']=htmlspecialchars($element['idJo']);
		$_SESSION['journ'][$cle]['nom']=htmlspecialchars($element['nom']);
		$_SESSION['journ'][$cle]['prenom']=htmlspecialchars($element['prenom']);
		$_SESSION['journ'][$cle]['dateNais']=htmlspecialchars($element['dateNais']);
		$_SESSION['journ'][$cle]['tel']=htmlspecialchars($element['tel']);
		$_SESSION['journ'][$cle]['email']=htmlspecialchars($element['email']);
		$_SESSION['journ'][$cle]['adr']=htmlspecialchars($element['adr']);
	}
}

$_SESSION['sujet']=sujet();
if (!empty($_SESSION['sujet']))
{
	foreach($_SESSION['sujet'] as $cle => $element)
	{
		$_SESSION['sujet'][$cle]['idSuj']=htmlspecialchars($element['idSuj']);
		$_SESSION['sujet'][$cle]['theme']=htmlspecialchars($element['theme']);
	}
}

$_SESSION['num']=num();
if (!empty($_SESSION['num']))
{
	foreach($_SESSION['num'] as $cle => $element)
	{
		$_SESSION['num'][$cle]['idNum']=htmlspecialchars($element['idNum']);
		$_SESSION['num'][$cle]['datePub']=htmlspecialchars($element['datePub']);
	}
}
$_SESSION['parut']=parut();
if (!empty($_SESSION['parut']))
{
	foreach($_SESSION['parut'] as $cle => $element)
	{
		$_SESSION['parut'][$cle]['idNum']=htmlspecialchars($element['idNum']);
		$_SESSION['parut'][$cle]['idArt']=htmlspecialchars($element['idArt']);
		$_SESSION['parut'][$cle]['datePar']=htmlspecialchars($element['datePar']);
	}
}
 //$xml='<?xml version="1.0" standalone="yes">'.'/n'.'<projet> /n';
 //$xml+=" <ligneEdito idLig=".">/n";
 //$xml+='<nom>'. '</nom>/n '.'<description>'. '</description>/n'.'</lignEdito>';

/* 
$xml= new XMLWriter();
$xml->openUri("donneesXML.xml");
	$xml->startDocument('1.0', 'utf-8');
		$xml->startElement('projet');
			
		  foreach($_SESSION['lign'] as $cle => $element)
		  { 
			$xml->startElement('lignEdito');
			$xml->writeAttribute('idLig', "");
			$xml->writeElement('description',"");
			$xml->endElement();
		  }
		  foreach($_SESSION['jour'] as $cle => $element)
		  { 
			$xml->startElement('lignEdito');
			$xml->writeAttribute('idLig', "");
			$xml->writeElement('description',"");
			$xml->endElement();
		  }
		$xml->endElement();
		
	$xml->endElement();
$xml->flush();*/
  ?>