<?php
include_once('../../Modele/requete.php');
$_SESSION['ListRep']=ListRep();
if(!empty($_SESSION['listRep']))
{
	foreach($_SESSION['listRep'] as $cle=>$rep)
	{
		$_SESSION['listRep'][$cle]['IDRepa']=htmlspecialchars($rep['IDRepa']);
		$_SESSION['listRep'][$cle]['En demande']=htmlspecialchars($rep['En demande']);
		$_SESSION['listRep'][$cle]['Prévue']=htmlspecialchars($rep['Prévue']);
		$_SESSION['listRep'][$cle]['En cours']=htmlspecialchars($rep['En cours']);
		$_SESSION['listRep'][$cle]['Terminée']=htmlspecialchars($rep['Terminée']);
	}
}
	//header("location../index.php?page=ListRep");

?>