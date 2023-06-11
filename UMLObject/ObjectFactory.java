package UMLObject;

public class ObjectFactory {
	
	public static Shape createShapeObj(int X,int Y,String shapeType) {
		if(shapeType == "class") {
			return new ClassObject(X,Y);
		}
		else if(shapeType == "usecase") {
			return new UseCase(X,Y);
		}
		
		return null;
	}
	
	
	public static BaseLineClass createLineObj(Port firstP,Port secondP,String lineType) {
		if(lineType == "association") {
			return new Line(firstP, secondP);
		}
		else if(lineType == "general") {
			return new GeneralLine(firstP, secondP);
		}
		else if(lineType == "composition") {
			return new CompositionLine(firstP, secondP);
		}
		
		return null;
	}
}
