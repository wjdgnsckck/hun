package java2.day27_컬랙션프레임워크2.Ex1_예제HashSet;

public class Member {
   
   // 필드
   public String name;
   public int age;
   
   
   public Member() {
      // TODO Auto-generated constructor stub
   }

   public Member(String name, int age) {
      super();
      this.name = name;
      this.age = age;
   }
   
   //--------------- 해당 객체의 중복 기준 만들기 --------------//
   //Object(모든 클래스는 Object으로부터 자동으로 상속받음)의 메소드를 재정의! 
   public int hashCode() {
      return name.hashCode()+age;
   }
   
   @Override
public String toString() {
	return "Member [name=" + name + ", age=" + age + "]";
}

public boolean equals(Object obj) {
      //if( obj instanceof Member target ) //javaSE-16이상
      if( obj instanceof Member target ) {
    	  //만약에 해당 객체가 이름과 나이가 일치하면 [ 중복 = true ]
         return target.name.equals(name) && (target.age == age);
      } else {
         return false;
      }
      
   }
   
//-------------------------------------------//

   
   
   
}