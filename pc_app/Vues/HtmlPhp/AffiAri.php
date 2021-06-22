<?php
//require '../../api/config.php';
//require '../../api/ari/liste_ari.php';
	$content = file_get_contents('http://ari.juliendrieu.fr/api/ari/liste_ari.php');
	$json = json_decode($content,true);
	?>
<html>
<head>
	<title>Liste des ARI</title>
	<meta charset="utf-8">
</head>
<style>
table {
  border: 2px solid black;
  border-collapse: collapse;
  text-align: center;
}
table td {
  border: 2px solid black; 
}
table th {
  border: 2px solid black; 
}
table tr:first-child td {
  border-top: 0;
}
table tr td:first-child {
  border-left: 0;
}
table tr:last-child td {
  border-bottom: 0;
}
table tr td:last-child {
  border-right: 0;
}
</style>
<body>
	<h3>La liste de tous les ARI</h3>
<table>
<thead>
  <tr>
    <th>ID</th>
    <th>Etat de Gonflage</th>
    <th>Lieu de Stock</th>
    <th>Reparation</th>
    <th>Controle</th>
    <th>Utilisation</th>
    <th>Vehicule</th>
  </tr>
</thead>
<tbody >
	<?php 
      foreach ($json['ari_list'] as $key => $value) {
			
	?>
  <tr >
    <td ><?php echo $json['ari_list'][$key]['id'];?></td>
    <td><?php echo $json['ari_list'][$key]['etat_gonflage'];?></td>
    <td><?php echo $json['ari_list'][$key]['lieu_stock'];?></td>
    <td><?php echo $json['ari_list'][$key]['reparation'];?></td>
    <td><?php echo $json['ari_list'][$key]['controle'];?></td>
    <td><?php echo $json['ari_list'][$key]['utilisation'];?></td>
    <td><?php echo $json['ari_list'][$key]['vehicule'];?></td>
  </tr>
  <?php
			};
  ?>
</tbody>
</table>
	<form method="POST" action="../../Controleur/retour.php">
	  <input type="submit" value="Retour"/>
	 </form>
</body>
</html>