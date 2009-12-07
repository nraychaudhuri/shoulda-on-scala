import org.junit.Assert._
class User(val fullName:String) {
  var profile:Profile = _
  def has_profile = profile.name != null
}

class Profile(val name:String) {}

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

new SUT
