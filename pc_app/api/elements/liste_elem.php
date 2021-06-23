<?php
require_once '../config.php';
try {
    $dataArray = array();
    $reponse = $bdd->query("SELECT * FROM elements");
    $donnees = $reponse->fetchALL();
    header ('Content-Type: application/json');
    foreach ($donnees as $key => $value) {
        $dataArray[$key]['id'] = $donnees[$key]['id'];
        $dataArray[$key]['materiel'] = $donnees[$key]['materiel'];
    }
    echo json_encode(array(
        'liste_elem'=> $dataArray,
    ));

} catch (Exception $e) {
    echo $e->getMessage();
}
