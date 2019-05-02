# multithreaded-socket-server
Java based multi threaded socket server program to manage	a	golf	competition. First	the	player	must	register	to	enter	the	competition.	Upon	a	successful registration	the	system	will	assign	a	competition	number	for	the	player.	After	playing	the	competition	the	player	must	enter	their	score	(eg.	76)	using	their	competition	number.	A	player	can	check	who	is	currently	winning	the	competition.

The	client has	three basic	operations:
1. Register Player with	the	system
   * Name ->	System	returns	Competition	Number (10102134)
2. Enter	their	score using	their	competition	number
   * Competition	Number
   * Score	(Integer	Value)  
3. Who	is	winning?
   * Return	player	with	the	lowest	score:	name	and	score. If	there	is	a	
tie	the	lowest	score	first	entered	wins.
4. Display	final	results
   * If	a	user	connects	to	the	socket	server	using	a	web	browser	the	
server	should	return	the	results	of	all	competitions	in	readable	
HTML	markup. (eg.	http://127.0.0.1:4444)
