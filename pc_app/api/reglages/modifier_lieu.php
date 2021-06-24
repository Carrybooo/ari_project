<?php
require_once '../config.php';
if (isset($_POST['id']) && isset($_POST['lieu_stock'])) {
    $insert = $bdd->prepare("UPDATE ari SET lieu_stock= ? WHERE id= ?");
    $insert->execute(array( $_POST['lieu_stock'],$_POST['id']));

echo "Le lieu de stock de ".$_POST['id']." a été modifié ";
}
else if (isset($_GET['id']) && isset($_GET['lieu_stock'])) {
    $insert = $bdd->prepare("UPDATE ari SET lieu_stock= ? WHERE id= ?");
    $insert->execute(array( $_GET['lieu_stock'],$_GET['id']));

echo json_encode("Le lieu de stock de ".$_GET['id']." a été modifié ");
}
else {
	echo json_encode('Les variables du formulaire ne sont pas déclarées');
}