package Tester.intermediateCertification.toyStore;

import java.util.logging.LogManager;
import java.util.logging.Logger;

import Tester.intermediateCertification.toyStore.controller.ControllerToy;
import Tester.intermediateCertification.toyStore.model.FileOperationToy;
import Tester.intermediateCertification.toyStore.model.MapperToy;
import Tester.intermediateCertification.toyStore.model.RepositoryToy;
import Tester.intermediateCertification.toyStore.view.ViewToy;


public class Main {
    public static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) throws Exception {
        LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("logging.properties"));
        logger.info("Main run.");
        FileOperationToy fileOperationToys = new FileOperationToy("toys.txt", logger);
        FileOperationToy fileOperationPrizeToys = new FileOperationToy("PrizeToys.txt", logger);
        FileOperationToy fileOperationGivenOutPrizeToys = new FileOperationToy("GivenOutPrizeToys.txt", logger);
        RepositoryToy repositoryToys = new RepositoryToy(fileOperationToys, new MapperToy());
        RepositoryToy repositoryPrizeToys = new RepositoryToy(fileOperationPrizeToys, new MapperToy());
        RepositoryToy repositoryGivenOutPrizeToys = new RepositoryToy(fileOperationGivenOutPrizeToys, new MapperToy());
        ControllerToy controllerToys = new ControllerToy(repositoryToys, logger);
        ControllerToy controllerPrizeToys = new ControllerToy(repositoryPrizeToys, logger);
        ControllerToy controllerGivenOutPrizeToy = new ControllerToy(repositoryGivenOutPrizeToys, logger);
        ViewToy view = new ViewToy(controllerToys, controllerPrizeToys, controllerGivenOutPrizeToy, logger);
        view.run();

    }
}
