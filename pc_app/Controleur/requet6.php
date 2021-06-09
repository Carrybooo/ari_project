 <?php 
Session_start();
include_once('../../Modele/requete.php');
$_SESSION['Listelem']=Listelem();
if (!empty($_SESSION['Listelem']))
{	foreach($_SESSION['Listelem'] as $cle=> $element)
	{//echo "cle :".$cle." <br/>"."element :".$element."<br/> ";
		$_SESSION['Listelem'][$cle]['ID']=htmlspecialchars($element['ID']);	
		$_SESSION['Listelem'][$cle]['Materiel']=htmlspecialchars($element['Materiel']);
	}
}
?>
