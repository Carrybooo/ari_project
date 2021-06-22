<?php
//require '../../api/config.php';
//require '../../api/ari/liste_ari.php';
	$content = file_get_contents('http://ari.juliendrieu.fr/api/elements/liste_elem.php');
	$json = json_decode($content,true);
	?>
<html>
<head>
	<title>Liste des Elements</title>
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
	<h3>La liste de tous les Elements</h3>
<table>
<thead>
  <tr>
    <th>ID</th>
    <th>Materiel</th>
  </tr>
</thead>
<tbody >
	<?php 
      foreach ($json['comp_list'] as $key => $value) {
			
	?>
  <tr >
    <td ><?php echo $json['comp_list'][$key]['id'];?></td>
    <td><?php echo $json['comp_list'][$key]['materiel'];?></td>
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