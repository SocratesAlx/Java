// Class that represents and auto insurance policy.

public class AutoPolicy 
{
   private int accountNumber;  // policy account number
   private String makeAndModel; // car that the policy applies to
   private String state; //  two-letter state abbreviation
   
   // constructor
   public AutoPolicy(int accountNumber, String makeAndModel, String state)
   {
    this.accountNumber = accountNumber;
    this.makeAndModel = makeAndModel;
    this.state = state;
   }

// sets the account number

public void setAccountNumber(int accountNumber)
{
    this.accountNumber = accountNumber;
}

// returns the account number
public int getAccountNumber()
{
    return accountNumber;
}

// sets the makeAndModel
public void setMakeAndModel(String makeAndModel)
{
    this.makeAndModel = makeAndModel;
}

// returns the makeAndModel
public String getMakeAndModel()
{
    return makeAndModel;
}

// sets the state
public void setState(String state)
{
    this.state = state;
}

// returns the state

public String getState()
{
    return state;
}

// predicate method retuns wether the state has no-fault insurance
public boolean isNoFaultState()
{
    boolean noFaultState;

    // determine wether state has no-fault auto insurance
    switch (getState()) // get AutoPolicy object's state abbreviation
    {
        case "MA" : case "NJ" : case "NY" : case "PA":
        noFaultState = true;
        break;
    default:
        noFaultState = false;
        break;       
    }

return noFaultState;
   }
} // end class AutoPolicy
