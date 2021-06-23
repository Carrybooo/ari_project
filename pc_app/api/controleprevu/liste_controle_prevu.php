<?php
require_once '../config.php';
try {
    $dataArray = array();
    $reponse = $bdd->query("SELECT * FROM controleprevu");
    $donnees = $reponse->fetchALL();
    header ('Content-Type: application/json');
    foreach ($donnees as $key => $value) {
        $dataArray[$key]['id'] = $donnees[$key]['id'];
        $dataArray[$key]['date'] = $donnees[$key]['date'];
        $dataArray[$key]['executeur'] = $donnees[$key]['executeur'];
    }
    echo json_encode(array(
        'liste_controle_prevu'=> $dataArray,
    ));

} catch (Exception $e) {
    echo $e->getMessage();
}
