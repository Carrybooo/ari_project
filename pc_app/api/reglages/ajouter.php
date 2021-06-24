<?php
require_once '../config.php';

if (isset($_POST['id']) && isset($_POST['etat_gonflage']) && isset($_POST['lieu_stock'])) {

    $insert1 = $bdd->prepare("INSERT INTO ari(id, etat_gonflage,lieu_stock ) VALUES (?,?,?)");
    $insert1->execute(array($_POST['id'], $_POST['etat_gonflage'], $_POST['lieu_stock']));
    echo "Ari " . $_POST['id'] . " ajouté ";
} 
else if (isset($_GET['id']) && isset($_GET['etat_gonflage']) && isset($_GET['lieu_stock'])) {

    $insert1 = $bdd->prepare("INSERT INTO ari(id, etat_gonflage,lieu_stock ) VALUES (?,?,?)");
    $insert1->execute(array($_GET['id'], $_GET['etat_gonflage'], $_GET['lieu_stock']));
    echo json_encode("Ari " . $_GET['id'] . " ajouté ");
} 
else {
    echo json_encode('Les variables du formulaire ne sont pas déclarées');
}
