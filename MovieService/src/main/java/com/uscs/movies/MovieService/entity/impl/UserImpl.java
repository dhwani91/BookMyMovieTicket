package com.uscs.movies.MovieService.entity.impl;
import com.uscs.movies.MovieService.entity.User;

	public class UserImpl implements User {
		private long id;
		private String firstName;
		private String lastName;
		private  String email;
		private String password;
			
		public UserImpl(long id) {
			this.id = id;
		}

		@Override
		public long getId() {
			return id;
		}

		@Override
		public String getFirstName() {
			return firstName;
		}

		@Override
		public String getLastName() {
			return lastName;
		}

		public String getEmail() {
			return email;
		}
		public String getPassword() {
			return password;
		}

		@Override
		public void setEmail(String email) {
			// TODO Auto-generated method stub
			this.email=email;
		
		}

		@Override
		public void setFirstName(String firstname) {
			// TODO Auto-generated method stub
			this.firstName=firstname;
			
		}

		@Override
		public void setLastName(String lastname) {
			// TODO Auto-generated method stub
			this.lastName=lastname;
			
		}

		@Override
		public void setPassword(String password) {
			// TODO Auto-generated method stub
			this.password=password;
		}	
		@Override
		public String toString() {
			return "UserImpl [id=" + id + ", firstName=" + firstName
					+ ", lastName=" + lastName + ", Email=" + email+ ",password="+password+"]";
		}
}
