

public class dslltest{
    /* Author: Dustin Hu
       Date: 02-12-2014
       Purpose: 
     */

    public static void main(String[] args) {
	// Author: Dustin Hu
	// Date: 03-12-2014
	// Purpose: To demonstarte the double sorted single linked list
	// Input: None
	// Output: None
	Dsll George = new Dsll();
	System.out.println("Why hello there, my name's George, and here's my train by number.");
	System.out.println(George.byNumber());
	System.out.println("Well okay, I apparently have no numbers. What if I try to walk through my train by name?");
	System.out.println(George.byName());
	System.out.println("Clearly, something's wrong. I'm missing some cars.");
	System.out.print("Where's my oil car? ");
	System.out.println(George.findBefore("oil"));
	System.out.print("Huh. What about car 6? ");
	System.out.println(George.findBefore(6));
	
	System.out.println("And what if we try to delete these nonexistent cars?");
	George.delete("oil");
	System.out.println(George.byName());
	System.out.println("Clearly, nothing when we delete oil. What if we delete car 6?");
	George.delete(6);
	System.out.println(George.byNumber());

	System.out.println("In that case, let's insert an oily 6th car.");
	George.insert("Oil", 6);
	System.out.println("Now what does my train look like?");
	System.out.println(George.byName());
	System.out.println(George.byNumber());

	System.out.println("So where is my 6th car?");
	System.out.println(George.find(6).byNumber());
	System.out.println("And the oil car?");
	System.out.println(George.find("Oil").byName());

	System.out.println("And Pacific Railways forbids the carrying of oil, so there goes my oil car.");
	George.delete("Oil");
	System.out.println(George.byName());
	System.out.println(George.byNumber());
	System.out.println("Well then, they're giving me some nicer cars.");
	George.insert("Potato", 3);
	George.insert("Coal", 4);
	George.insert("Uranium", 27);
	George.insert("Robots", 14);
	George.insert("Plutonium", 124);
	System.out.println("Hrm.... Why is my train glowing? Let's take a walk and see.");
	System.out.println(George.byName());
	System.out.println(George.byNumber());
	System.out.println("WHY DID THEY GIVE ME URANIUM");
	System.out.println("I'm getting rid of the uranium.");
	George.delete("Uranium");
	System.out.println("So now I don't have any more uranium.");
	System.out.println(George.byName());
	System.out.println(George.byNumber());
    }

}
class Node{
    /*
      AUthor: Dustin Hu
      Date: 02-12-2014
      Purpose: To be the node class
      
      Fields: 
          name: The name of the node
	  number: The number of the node
	  nextName: The next node, by name
	  nextNumber: The next node, by number
	  

      Methods:
          Node: No parameters, creates an empty node
	  Node: 2 parameters, creates a node
     */
    public String name;
    public int number;
    public Node nextName;
    public Node nextNumber;

    public Node(){
	// Author: Dustin Hu
	// Date: 02-12-2014
	// Purpoes: To create a node
	// Input: None
	// Output: None
	this(0, "");

    }
    public Node(int number, String name){
	// Author: Dustin Hu
	// Date: 02-12-2014
	// Purpoes: To create a node
	// Input: The number and the name of the node
	// Output: None
	this.number = number;
	this.name = name;
	this.nextName = null;
	this.nextNumber = null;
    }
    public String byName(){
	// Author: DUstin Hu
	// Date: 02-12-2014
	// Purpoes: To get the string of the node by name
	// Input: None
	// Output: A string, the node and all subquesent nodes by name
	String output = "";

	if (this.nextName == null){
	    output = output + this.name + " -> NULL";
	}
	else{
	    output = output + this.name + " -> " + this.nextName.byName();
	}
	return output;
    }
    public String byNumber(){
	// Author: DUstin Hu
	// Date: 02-12-2014
	// Purpoes: To get the string of the node by number
	// Input: None
	// Output: A string, the node and all subquesent nodes by number
	String output = "";

	if (this.nextNumber == null){
	    output = output + this.number + " -> NULL";
	}
	else{
	    output = output + this.number + " -> " + this.nextNumber.byNumber();
	}
	return output;
    }
}
class Dsll{
    /*
      Author: Dustin Hu
      Date: 02-12-2014
      Purpoes: To be the double sorted linked list
      Fields:
          listName: The list by names
	  listNumber: The list by number

      Methods:
          Dsll: A constructor with no parametres
	  Dsll: A constructor with the int and the string parameters
	  byName: Gets the stirng by name
	  byNumber: Gets the string by number
	  inList: Checks if an integer node is in the list
	  inList: checksi f a string node is in the list
	  getLastNumber: Gets the last number node
	  getLastName: Gets the last name node
	  findBefore: Finds the node before a number
	  findBefore: Finds the node before a name
	  insert: Inserts a name
	  insert: Inserts a number
	  insert: Inserts a node
	  find: Finds the number node
	  find: Finds the name node
	  delete: deletes a node given a name
	  delete: Deletes a node given a number
     */ 
    protected Node listName;
    protected Node listNumber;

    public Dsll(){
	// Author: Dustin Hu
	// Date: 02-12-2014
	// Purpose: To create the double single linked list
	// Input: None
	// Output: None

	this.listName = null;
	this.listNumber = null;
    }
    public Dsll(int number, String name){
	// Author: Dustin Hu
	// Date: 02-12-2014
	// Purpose: To create the double single linked list
	// Input: The number and name of the first node
	// Output: None
	Node temp = new Node(number, name);
	this.listName = temp;
	this.listNumber = temp;
    }
    public String byName(){
	// Autohr: Dustin Hu
	// Date: 02-12-2014
	// Purpose: To print by name
	// Input: None
	// Output: This lists's nodes by name
	String output;
	if (this.listName != null){
	    output = this.listName.byName();
	}
	else{
	    output = "NULL";
	}
	return output;
    }
    public String byNumber(){
	// AUthor: Dustin Hu
	// Date: 02-12-2014
	// Purpose: To print by numberx
	// Input: None
	// Output: The lists's nodes by number
	String output;
	if (this.listName != null){
	    output = this.listName.byName();
	}
	else{
	    output = "NULL";
	}
	return output;
    }
    public boolean inList(int input){
	// AutohR: Dustin hu
	// daet: 02-12-2014
	// Purpoes: To check whetehr or not a number is in the list
	// Input: The number to look for
	// Output: True if the number is in the list, false otherwise
	boolean inList = false;
	Node current = this.listNumber;
	while (current != null && inList == false){
	    if (current.number == input){
		inList = true;
	    }
	    else{
		current = current.nextNumber;
	    }
	}
	return inList;
    }
    public boolean inList(String input){
	// AutohR: Dustin hu
	// daet: 02-12-2014
	// Purpoes: To check whetehr or not a string is in the list
	// Input: The name to look for
	// Output: True if the name is in the list, false otherwise
	boolean inList = false;
	Node current = this.listName;
	while (current != null && inList == false){
	    if (current.name.equals(input)){
		inList = true;
	    }
	    else{
		current = current.nextName;
	    }
	}
	return inList;
    }
    public Node getLastNumber(){
	// Autohr: Dustin Hu
	// Date: 02-12-2014
	// Purpoes: To get the last number
	// Input: None 
	// Output: The last number node
	Node previous = null;
	Node current = this.listNumber;
	while (current != null){
	    previous = current;
	    current = current.nextNumber;
	}
	return previous;
    }
    public Node getLastName(){
	// Author: Dsutin Hu
	// Date: 02-12-2014
	// Purpoes: To get the last name
	// Input: None
	// Output: The last name node
	Node previous = null;
	Node current = this.listName;
	while (current != null){
	    previous = current;
	    current = current.nextName;
	}
	return previous;
    }
    public Node findBefore(int input){
    	// Author: Dustin Hu
    	// Daet: Dustin Hu
    	// Date: 02-12-2014
    	// Purpoes To find the previous node
    	// Input: THe number to find
    	// Output: The node before the node containin the input
    	Node previous = null;
    	Node current = this.listNumber;
    	boolean walk = true;

	while (current != null && input  > current.number){
	    previous = current;
	    current = current.nextNumber;
	}
	return previous;

    	// while (walk == true){
    	//     if (current == null){
	// 	previous = this.getLastNumber();
    	// 	walk = false;
		
    	//     }
    	//     else{

    	//     }
    	// }

    }
    public Node findBefore(String input){
    	// Author: Dustin Hu
    	// Daet: Dustin Hu
    	// Date: 02-12-2014
    	// Purpoes To find the previous node
    	// Input: THe name to find
    	// Output: The node before the node containin the input

    	Node previous = null;
    	Node current = this.listName;
    	boolean walk = true;

	while (current != null && input.compareTo(current.name) > 0){
	    previous = current;
	    current = current.nextNumber;
	}
	return previous;

    	// while (walk == true){
    	//     if (current == null){
	// 	previous = this.getLastNumber();
    	// 	walk = false;
		
    	//     }
    	//     else{

    	//     }
    	// }

    }
    public void insert (Node input, String name){
	// AuthoR: Dustin Hu
	// Date: 03-12-2014
	// Purpoes: TO insert a node by name
	// Input: THe node to insert and the string 
	// Output: None
	Node before = this.findBefore(name);
	if (before == null){
	    input.nextName = this.listName;
	    this.listName = input;
	}
	else{
	    input.nextName = before.nextName;
	    before.nextName = input;
	}
    }
    public void insert (Node input, int number){
	// Author: dustin Hu
	// Date: 03-12-2014
	// Purpose: To insert a node by number
	// Input: The node to insert and the number
	// Output: None
	Node before = this.findBefore(number);
	if (before == null){
	    input.nextNumber = this.listNumber;
	    this.listNumber = input;
	}
	else{
	    input.nextNumber = before.nextNumber;
	    before.nextNumber = input;
	}
    }
    public void insert (String name, int number){
	// Author: Dustin Hu
	// date: 03-12-2014
	// Purpoes: To insert a node
	// Input: The name and the number
	// Output: None
	Node input = new Node(number, name);
	Node beforeNumber = this.findBefore(number);


	// Handle name first
	this.insert(input, name);
	// Handle number
	this.insert(input, number);
    }
    public Node find(int number){
	// Author: Dustin Hu
	// Date: 03-12-2014
	// Purpose: To find a node with a given number
	// Input: The number ot find
	// Output: null if not in list, else the node
	Node before;
	Node output;
	if (this.inList(number) == false){
	    output = null;
	}
	else{
	    before = this.findBefore(number);
	    if (before == null){
		output = this.listNumber;
	    }
	    else{
		output = before.nextNumber;
	    }

	}
	return output;
    }
    public Node find(String name){
	// Author: Dustin Hu
	// Date: 03-12-2014
	// Purpose: To find a node with a name
	// Input: The name to find
	// Output: The node, if found, and null if it's not in the list'
	Node before;
	Node output;
	if (this.inList(name) == false){
	    output = null;
	}
	else{
	    before = this.findBefore(name);
	    if (before == null){
		output = this.listName;
	    }
	    else{
		output = before.nextName;
	    }
	}

	return output;
    }
    public void delete (String name){
	// AUthor: Dustin Hu
	// Date: 03-12-2014
	// Purpose: To delete a node given the name
	// Input: The name of the onde to delete
	// Output: None
	Node toBeRemoved;

	Node previous;
	Node current;
	Node after;
	if (this.inList(name)){

	    toBeRemoved = this.find(name);

	    if (this.listName.name.equals(name)){
		this.listName = this.listName.nextName;
	    }
	    else if (this.getLastName().name == name){
		this.findBefore(name).nextName = null;
	    }
	    else{
		previous = this.findBefore(name);
		current = previous.nextName;
		after = current.nextName;
		previous.nextName = after;
	    }

	    if (this.listNumber.number == toBeRemoved.number) {
		this.listNumber = this.listNumber.nextNumber;
	    }
	    else if (this.getLastNumber().number == toBeRemoved.number){
		this.findBefore(toBeRemoved.number).nextNumber = null;
	    }
	    else{
		previous = this.findBefore(toBeRemoved.number);
		current = previous.nextNumber;
		after = current.nextNumber;
		previous.nextNumber = after;
	    }
	    
	}
	else{
	}


    }
    public void delete(int number){
	// AUthor: Dustin Hu
	// Date: 03-12-2014
	// Purpose: To delete a node given the number
	// Input: The number of the onde to delete
	// Output: None
	Node toBeRemoved;

	Node previous;
	Node current;
	Node after;
	if (this.inList(number)){

	    toBeRemoved = this.find(number);

	    if (this.listNumber.number == number){
		this.listNumber = this.listNumber.nextNumber;
	    }
	    else if (this.getLastNumber().number == number){
		this.findBefore(number).nextNumber = null;
	    }
	    else{
		previous = this.findBefore(number);
		current = previous.nextNumber;
		after = current.nextNumber;
		previous.nextNumber = after;
	    }

	    if (this.listName.name.equals(toBeRemoved.name)) {
		this.listName = this.listName.nextName;
	    }
	    else if (this.getLastName().name.equals(toBeRemoved.name)){
		this.findBefore(toBeRemoved.name).nextNumber = null;
	    }
	    else{
		previous = this.findBefore(toBeRemoved.name);
		current = previous.nextName;
		after = current.nextName;
		previous.nextName = after;
	    }
	    
	}
	else{
	}
	
    }
    
}
