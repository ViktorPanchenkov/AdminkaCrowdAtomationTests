package Steps;

import Pages.OffenciveWordsPage;
import net.thucydides.core.annotations.Step;

public class OffenciveWordsPageSteps {
   OffenciveWordsPage offenciveWordsPage;

   @Step
   public void EnterNewOffenciveWord(String Word)
   {
      offenciveWordsPage.EnterNewOffencivewordInInput(Word);
   }
   @Step
   public void ClcikOnAddOfenciveWordButton(){
      offenciveWordsPage.ClcikOnAddOfenciveWordButton();
   }

}
