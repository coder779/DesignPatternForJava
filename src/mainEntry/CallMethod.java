package mainEntry;

import DesignImpl.stratrgyPattern.*;

import java.util.ArrayList;
import java.util.List;

import DesignImpl.Adapter.*;
import DesignImpl.Bridge.*;
import DesignImpl.Bridge.Circle;
import DesignImpl.FilterPattern.*;
import DesignImpl.Observer.*;
import DesignImpl.abstractFactoryPattern.*;

public class CallMethod {
	public void callStrategy(boolean isShow) {
		if (isShow) {
			Context context = new Context(new OperationAdd());
			System.out.println("10 + 5 = " + context.executeStrategy(10, 5));
	
			context = new Context(new OperationSubtract());
			System.out.println("10 - 5 = " + context.executeStrategy(10, 5));
	
			context = new Context(new OperationMultiply());
			System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
		}
	}
	
	public void CallAbstractFactory(boolean isShow) {
		if (isShow) {
			// 获取形状工厂
			AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

			// 获取形状为 Circle 的对象
			Shape shape1 = shapeFactory.getShape("CIRCLE");

			// 调用 Circle 的 draw 方法
			shape1.draw();

			// 获取形状为 Rectangle 的对象
			Shape shape2 = shapeFactory.getShape("RECTANGLE");

			// 调用 Rectangle 的 draw 方法
			shape2.draw();

			// 获取形状为 Square 的对象
			Shape shape3 = shapeFactory.getShape("SQUARE");

			// 调用 Square 的 draw 方法
			shape3.draw();

			// 获取颜色工厂
			AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

			// 获取颜色为 Red 的对象
			Color color1 = colorFactory.getColor("RED");

			// 调用 Red 的 fill 方法
			color1.fill();

			// 获取颜色为 Green 的对象
			Color color2 = colorFactory.getColor("GREEN");

			// 调用 Green 的 fill 方法
			color2.fill();

			// 获取颜色为 Blue 的对象
			Color color3 = colorFactory.getColor("BLUE");

			// 调用 Blue 的 fill 方法
			color3.fill();
		}

	}
	
	public void callAdapterPattern(boolean isShow) {

		if (isShow) {
			AudioPlayer audioPlayer = new AudioPlayer();

			audioPlayer.play("mp3", "beyond the horizon.mp3");
			audioPlayer.play("mp4", "alone.mp4");
			audioPlayer.play("vlc", "far far away.vlc");
			audioPlayer.play("avi", "mind me.avi");
		}
	}

	public void callBridgePattern(boolean isShow) {
		if (isShow) {
			Shape2 redCircle = new Circle(100, 100, 10, new RedCircle());
			Shape2 greenCircle = new Circle(100, 100, 10, new GreenCircle());

			redCircle.draw();
			greenCircle.draw();
		}
	}

	public void callObserverPattern(boolean isShow) {
		if (isShow) {
			Subject subject = new Subject();

			new HexaObserver(subject);
			new OctalObserver(subject);
			new BinaryObserver(subject);

			System.out.println("First state change: 15");
			subject.setState(15);
			System.out.println("Second state change: 10");
			subject.setState(10);
		}
	}
	
	public void callCriteriaPattern(boolean isShow) {
		if (isShow) {

			List<Person> persons = new ArrayList<Person>();

			persons.add(new Person("Robert", "Male", "Single"));
			persons.add(new Person("John", "Male", "Married"));
			persons.add(new Person("Laura", "Female", "Married"));
			persons.add(new Person("Diana", "Female", "Single"));
			persons.add(new Person("Mike", "Male", "Single"));
			persons.add(new Person("Bobby", "Male", "Single"));

			Criteria male = new CriteriaMale();
			Criteria female = new CriteriaFemale();
			Criteria single = new CriteriaSingle();
			Criteria singleMale = new AndCriteria(single, male);
			Criteria singleOrFemale = new OrCriteria(single, female);

		      System.out.println("Males: ");
		      UtilForFilter.printPersons(male.meetCriteria(persons));
		 
		      System.out.println("\nFemales: ");
		      UtilForFilter.printPersons(female.meetCriteria(persons));
		 
		      System.out.println("\nSingle Males: ");
		      UtilForFilter.printPersons(singleMale.meetCriteria(persons));
		 
		      System.out.println("\nSingle Or Females: ");
		      UtilForFilter.printPersons(singleOrFemale.meetCriteria(persons));
		}
	}
}
