package cloudgene.mapred.cli;

import cloudgene.mapred.apps.Application;

public class RemoveApplication extends BaseTool {

	private String cmd = "cloudgene";

	public RemoveApplication(String[] args) {
		super(args);
	}

	@Override
	public void createParameters() {

	}

	@Override
	public int run() {
		if (args.length != 1) {
			System.out.println("Usage: " + cmd + "remove <name> ");
			System.out.println();
			System.exit(1);
		}

		String id = args[0];
		try {

			Application application = repository.getById(id);
			if (application == null) {
				printlnInRed("[ERROR] Application " + id + " is not in your local repository.\n");
				return 1;
			}

			repository.remove(application);

			printlnInGreen("[OK] Application removed.\n");
			settings.save();
			return 0;

		} catch (Exception e) {
			printlnInRed("[ERROR] Application not removed:" + e.toString() + "\n");
			return 1;
		}

	}

}