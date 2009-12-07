About
=====

Shoulda on Scala - Nano unit testing framework for Scala. My attempt to port simple library testing like Shoulda which is a Ruby testing framework to Scala. 

Example
=======

class SUT extends Shoulda {
  context /"A User instance"/ {
    val user = new User("Full name")
    should /"return its full name"/ {
      assertEquals("Full name", user.fullName)
    }
    
    context /"with a profile"/ {
      user.profile = new Profile("profile name")      
      should /"return true when sent has_profile"/ {
        assertTrue(user.has_profile)
      } 
    }  
  }
}

To run the test, just instantiate the class and it produces the following results
"test: A User instance return its full name"
"test: A User instance with a profile return true when sent has_profile"

The above example uses Junit assertions, but we could use any other assertion or matcher library

Todo
====

* show assert failure messages with line numbers
* helpers for Lift
