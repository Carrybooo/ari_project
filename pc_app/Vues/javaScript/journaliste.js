function testVide()
{
	if (!empty($_POST['nom']))
	{
		if ($_POST['nom'].length>25)
		{
			document.write("La taille du nom est inferieur à 25");
		}
	}
}