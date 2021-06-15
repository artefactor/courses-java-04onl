package by.teachmeskills.opetation;

//@Component
public class LogarithmOperation extends AbstractSimpleOperation {
	@Override
	public double process(int a, int b) {
		return Math.log(a) / Math.log(b);
	}
}
