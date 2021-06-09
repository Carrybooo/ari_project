<?php
	session_start();
	include_once('../../Modele/requete.php');
	$_SESSION['ListRep']=ListRep();
	if(!empty($_SESSION['listRep']))
{
	foreach($_SESSION['listRep'] as $cle=>$art)
	{
		$_SESSION['listRep'][$cle]['IDRepa']=htmlspecialchars($art['IDRepa']);
		$_SESSION['listRep'][$cle]['En demande']=htmlspecialchars($art['En demande']);
		$_SESSION['listRep'][$cle]['Prévue']=htmlspecialchars($art['Prévue']);
		$_SESSION['listRep'][$cle]['En cours']=htmlspecialchars($art['En cours']);
		$_SESSION['listRep'][$cle]['Terminée']=htmlspecialchars($art['Terminée']);
	}
}
	//header("location../index.php?page=ListRep");

?>