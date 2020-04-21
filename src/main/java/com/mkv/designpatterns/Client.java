package com.mkv.designpatterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mkv.designpatterns.chainofresponsibility.AmericanExpressCardHandler;
import com.mkv.designpatterns.chainofresponsibility.DiscoverCardHandler;
import com.mkv.designpatterns.chainofresponsibility.MasterCardHandler;
import com.mkv.designpatterns.chainofresponsibility.VisaCardHandler;
import com.mkv.designpatterns.chainofresponsibility.CreditCardHandler;
import com.mkv.designpatterns.factory.AmericanExpressCardFactory;
import com.mkv.designpatterns.factory.CardFactory;
import com.mkv.designpatterns.factory.DiscoverCardFactory;
import com.mkv.designpatterns.factory.InvalidCardFactory;
import com.mkv.designpatterns.factory.MasterCardFactory;
import com.mkv.designpatterns.factory.VisaCardFactory;
import com.mkv.designpatterns.model.CreditCard;
import com.mkv.designpatterns.model.CreditCardTypes;
import com.mkv.designpatterns.model.FileInputObject;
import com.mkv.designpatterns.strategy.FileContext;
import com.mkv.designpatterns.strategy.FileStrategy;

public class Client{

	public static void main(String[] args){

		String inputFile;
		CardFactory factory;
		CreditCard creditCard;
		FileContext fileContext;
		List<FileInputObject> fileObjectList;
		List<CreditCard> creditCardsList;

		if(args.length == 0)
			System.out.print("No Valid Input File");
		else {
			inputFile = args[0];

			// 1. Choose File Handling strategy
			fileContext = new FileContext();
			fileContext.chooseFileStrategy(inputFile);
			FileStrategy fileStrategy = fileContext.getStrategy();

			// 2. Read Input File
			fileObjectList = fileStrategy.readFromFile(inputFile);

			// 3. Initialize Card Hanlers and Set up Chain
			CreditCardHandler amexCardHandler = new AmericanExpressCardHandler();
			CreditCardHandler discoverCardHandler = new DiscoverCardHandler();
			CreditCardHandler masterCardHandler = new MasterCardHandler();
			CreditCardHandler visaCardHandler = new VisaCardHandler();
			amexCardHandler.setNextHandler(discoverCardHandler);
			discoverCardHandler.setNextHandler(masterCardHandler);
			masterCardHandler.setNextHandler(visaCardHandler);

			// 3. Check Card Number Validity and Handler
			creditCardsList = new ArrayList<>();
			CreditCardTypes cardType ;
			factory = new InvalidCardFactory();
			for (FileInputObject fileObject: fileObjectList) {
				cardType = amexCardHandler.handleRequest(fileObject.getCardNumber());
				if(cardType != null) {
					switch(cardType){
					case AmericanExpress: factory = new AmericanExpressCardFactory();
						break;
					case Discover: factory = new DiscoverCardFactory();
						break;
					case MasterCard: factory = new MasterCardFactory();
						break;
					case Visa: factory = new VisaCardFactory();
					}
				}
				creditCard = factory.createCard(fileObject.getCardNumber(),
						fileObject.getExpirationDate(),
						fileObject.getNameOfCardHolder());
				creditCardsList.add(creditCard);
			}
			fileStrategy.writeToFile(creditCardsList);
		}







	}

}
/*{

    public static void main( String[] args )
    {
        List<List> ccList ;
        Client client=new Client();
        boolean flag=false;
        int a;
        CardFactory card = new CreditCardFactory();

        System.out.println( "Hello World!" );
        System.out.println("Reading CSV file");

        ccList=client.readCSVFile();
        System.out.println(ccList);
        System.out.println("Reading row verifies credit card number is a possible account number");

        String name = "John Oliver";
        String ccNumber = "123456789123456";
        Date d = new Date();

        //Use Strategy pattern to verify credit card
        *//*for(int i=0;i<ccList.size();i++){
            Context context=new Context(ccList.get(i));
            context.changeStrategy(new ValidateVisaCard());

            if(context.doValidate()){
                // call factory visa
                CreditCard creditcard = card.createCard(context.getType(),(String)ccList.get(i).get(0),new Date(),(String)ccList.get(i).get(2));
                System.out.println("1");
                break;
            }
            else{
                context.changeStrategy(new ValidateMasterCard());
                if(context.doValidate()){
                    // create factory master card
                    CreditCard creditcard = card.createCard(context.getType(),(String)ccList.get(i).get(0),new Date(),(String)ccList.get(i).get(2));
                    System.out.println("2");
                    break;
                }
                else{
                    context.changeStrategy(new ValidateDiscoverCard());
                    if(context.doValidate()){
                        // create discover factory
                        CreditCard creditcard = card.createCard(context.getType(),(String)ccList.get(i).get(0),new Date(),(String)ccList.get(i).get(2));
                        break;
                    }
                    else{
                        context.changeStrategy(new ValidateAmExCard());
                        if(context.doValidate()){
                            //create amex
                            CreditCard creditcard = card.createCard(context.getType(),(String)ccList.get(i).get(0),new Date(),(String)ccList.get(i).get(2));
                            break;
                        }
                        else{
                            // invalid
                            System.out.println("Invalid Credit card");
                            break;
                        }
                    }

                }
            }

           *//**//* if(flag){
                CardFactory card = new CreditCardFactory();
                CreditCard creditcard = card.createCard(context.getType(),(String)ccList.get(i).get(0),new Date(),(String)ccList.get(i).get(2));
            }*//**//*

        }*//*

        //context.changeStrategy(new ValidateVisaCard());
        //context.doValidate();
        //Use Factory Pattern to create objects
       // CardFactory card = new CreditCardFactory();
        //CreditCard creditcard = card.createCard("Discover","4000000000000",new Date(),"Mark");


    }
    public List readCSVFile(){
        String csvFile = "/Users/geethu/Desktop/sampleCreditCardData.csv";
        String line = "";
        String cvsSplitBy = ",";

        List<List> creditCardList=new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                List list = new ArrayList<>();
                // use comma as separator
                String[] cc = line.split(cvsSplitBy);

                System.out.println("cardNumber= " + cc[0] + " , expirationDate=" + cc[1] + " , creditCardHolderName=" + cc[2]);
                //CreditCard c= new VisaCC(cc[0],new Date(),cc[2]);
                list.add(cc[0]);
                list.add(cc[1]);
                list.add(cc[2]);
                creditCardList.add(list);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return creditCardList;
    }
}*/
