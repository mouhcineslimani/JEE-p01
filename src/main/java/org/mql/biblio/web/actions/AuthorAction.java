package org.mql.biblio.web.actions;

import org.mql.biblio.models.Author;

public class AuthorAction {
	private Author author ; 
	
	public AuthorAction() {
 	}

	/*
	 * methode d'action 
	 */
	
	// les actions return String : nom de view 
	public String searchAuthor()
	{
		author = new Author(101,"James Gosling",1955) ; 
		return "print-author";
	}
		
	/*
	 * methodes de récuperation de models ;  
	 */
	
	public Author getAuthor() {
		return author;
	}
	
	
	
}
