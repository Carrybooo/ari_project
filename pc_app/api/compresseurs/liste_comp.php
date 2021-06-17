<?php
require_once '../config.php';
try {
    $dataArray = array();
    $reponse = $bdd->query("SELECT * FROM compresseurs");
    $donnees = $reponse->fetchALL();
    header ('Content-Type: application/json');
    foreach ($donnees as $key => $value) {
        $dataArray[$key]['id'] = $donnees[$key]['id'];
        $dataArray[$key]['fonctionnel'] = $donnees[$key]['fonctionnel'];
        $dataArray[$key]['lieu_stock'] = $donnees[$key]['lieu_stock'];
        $dataArray[$key]['reparation'] = $donnees[$key]['reparation'];
        $dataArray[$key]['controle'] = $donnees[$key]['controle'];
        $dataArray[$key]['utilisation'] = $donnees[$key]['utilisation'];
        $dataArray[$key]['vehicule'] = $donnees[$key]['vehicule'];
    }
    echo json_encode(array(
        'comp_list'=> $dataArray,
    ));

} catch (Exception $e) {
    echo $e->getMessage();
}
