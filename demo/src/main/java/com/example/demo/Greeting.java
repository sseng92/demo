package com.example.demo;

// POJO - Plain Old Java Object
// Greeting Class where data stored
public class Greeting {
//final means constant
		private final long id;
		private final String content;
		
		public Greeting(long id, String content) {
			this.id = id;
			this.content = content;
			
			
		}
		
		public long getID() {
			return id;
		}
		
		public String getContent() {
			return content;
			
		}
		
}
