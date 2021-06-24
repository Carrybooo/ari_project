<?php
require_once '../config.php';

if (isset($_POST['id'])) {

    $insert1 = $bdd->prepare("DELETE FROM ari WHERE id= ? ");
    $insert1->execute(array($_POST['id']));
    echo "Ari " . $_POST['id'] . " retiré ";

}
else if (isset($_GET['id'])) {

    $insert1 = $bdd->prepare("DELETE FROM ari WHERE id= ? ");
    $insert1->execute(array($_GET['id']));
    echo json_encode("Ari " . $_GET['id'] . " retiré ");

} else {
    echo json_encode('Les variables du formulaire ne sont pas déclarées');
}