# <h1>MOWER-1.0</h1>
<p>The purpose of this app is to reflect technical skills in a hiring process context.</p>

<hr>
<h2>Requirment:</h2>
<p>This app was developped for java 7.</p>

<hr>
<h2>Quick start:</h2>

<p>In a console : java -jar Mower-1.0.jar instructions.txt<br />
instructions.txt and Mower-1.0.jar need to be in the same directory.<br />
instructions.txt is a configuration file.</p>

<hr>
<h2>Help:</h2>

<p>In a console : java -jar Mower-1.0.jar -h</p>

<hr>
<h2>Description:</h2>

<p>This app moves mowers on a garden.<br />
When a mower has finished his sequence movement, the mower gives his position and direction.<br />
Only one mower can move at a time.</p>

<p>The configuration file needs:<br />
<ul>
<li>a first line defining the garden.<br />
For example: a first line like '5 5' gives the top right coordinate of the garden (5,5) on a (x,y) referential. The bottom left coordinate is always (0,0).</li>
<li>and one or several bloc of two lines to define a mower.
For example:
<ul><li>First line of a bloc give the initial coordinates position of the mower. '1 2 N' means coordinates (1,2) and direction North.</li>
<li>Second line of a bloc give a sequence for moving the mower. 'ADGA' means move forward, then turn right, then turn left, then move forward.</li></ul>
</li>
</ul></p>
<p>You can use N E W S for direction respectively North, East, West and South.<br />
You can use A D G for moving respectively 'A' for moving forward,'D' for turning right, 'G' for turning left'.<br />
Empty line will be skiped.<br />
In case of syntax error, line and pattern to match will be given.</p>

<p>Following lines are a valid configuration:<br />
5 5<br />
1 2 N<br />
GAGAGAGAA<br />
3 3 E<br />
AADAADADDA</p>

<p>This valid configuration gives folowing result:<br />
1 3 N<br />
5 1 E<br />
</p>

<hr>
<h2>Limitations:</h2>
<p>Collision beetween mowers are not supported.</p>

<hr>
Author : Alexandre Bourget.
