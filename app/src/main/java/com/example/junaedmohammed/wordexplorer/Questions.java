package com.example.junaedmohammed.wordexplorer;

/**
 * Created by Junaed Mohammed on 30-Jan-18.
 */

public class Questions {

       public String mQuestions[] = {
               "What is the synonym  of Term ?",
               "What is the synonym of Schedule ?",
               "What is the synonym of Great ?",
               "What is the synonym of Abandon ?",
               "What is the synonym of Balance ?",
               "What is the synonym of Consider ?",
               "What is the synonym of Description ?",
               "What is the synonym of Experience ?",
               "What is the synonym of Fair ?",
               "What is the synonym of Height ?",
               "What is the synonym of Issue ?",
               "What is the synonym of Join ?",
               "What is the synonym of Kind ?",
               "What is the synonym of Leave ?",
               "What is the synonym of Meet ?",
               "What is the synonym of Nice ?",
               "What is the synonym of Opinion ?",
               "What is the synonym of Purpose ?",
               "What is the synonym of Quote ?",
               "What is the synonym of Rush ?",
               "What is the synonym  of Depute ?",
               "What is the antonym of Crafty ?",
               "What is the synonym of Admonish ?",
               "What is the antonym of Drippy ?",
               "What is the synonym of Expunge ?",
               "What is the antonym of Thwart ?",
               "What is the synonym of Stupefy ?",
               "What is the antonym of Worship ?",
               "What is the synonym of Uncertain ?",
               "What is the antonym of Tenant ?",
               "What is the synonym of Ignoble ?",
               "What is the antonym of Facsimile ?",
               "What is the synonym of Flawless ?",
               "What is the antonym of Scion ?",
               "What is the synonym of Recede ?",
               "What is the antonym of Valiant ?",
               "What is the synonym of Trust ?",
               "What is the antonym of Xenophobia ?",
               "What is the synonym of Slick ?",
               "What is the antonym of Provoke ?",
               "What is the synonym of Omen ?",
               "What is the antonym of Console ?",
               "What is the synonym of Elude ?",
               "What is the antonym of Kidnap ?",
               "What is the synonym of Hustle ?",
               "What is the antonym of Simulation ?",
               "What is the synonym of Noose ?",
               "What is the antonym of Pleasure ?",
               "What is the synonym of Slope ?",
               "What is the antonym of Profuse ?",




       };

       public String mChoice[][] = {

               {"Achieve","Period","Mutant","Gold"},
               {"Clop","Widget","Cadastre","Wait"},
               {"Envisage","Mandatory","Obsession","Winky"},
               {"Ambition","Portrayal","Odd","Watch"},
               {"Adroit","Innocent","Natural","Wisdom"},
               {"Depict","Desination","Rough","Hipocracy"},
               {"Provision","Manner","Offer","Naive"},
               {"Beware","Regret","Origin","Nomenclature"},
               {"Arrival","Equitable","Allegible","Udder"},
               {"Appetite","Native","Elevation","Joust"},
               {"Disclosure","Erase","Orca","Waste"},
               {"Haven","Manipulate","Adjoin","Hutch"},
               {"Addicted","Odd","Feasible","Gracious"},
               {"Aloft","Naval","Adieu","Adhere"},
               {"Symposium","Maturity","Odd","Aisle"},
               {"Ajar","Accurate","New","Lush"},
               {"Rejoice","Nourish","Omen","Counsel"},
               {"Arise","Ductile","Intention","Weary"},
               {"Excerpt","Manipulate","Louche","Bold"},
               {"Inherent","Reed","Ordinary","Brutal"},
               {"Deride","Delegate","Wickedness","Corrupt"},
               {"Cunning","Wily","Naive","Vulpine"},
               {"Flatter","Permit","Laud","Upbraid"},
               {"Mawkish","Emotional","Sobby","Corny"},
               {"Add","Omit","Allow","Insert"},
               {"Curb","Ditch","Dodge","Encourage"},
               {"Benumb","Enliven","Wicked","Remorseful"},
               {"Awe","Glory","Disdain","Praise"},
               {"Safe","Foreseeable","Hesitant","Weird"},
               {"Renter","Landlord","Holder","Dweller"},
               {"Abject","Dignified","Odd","Worthy"},
               {"Carbon","Clon","Original","Vulpine"},
               {"Corrupt","Invigious","Irreproachable","Upbraid"},
               {"Twig","Seed","Root","Shoot"},
               {"Enhance","Forge","Lessen","Prolong"},
               {"Great","Plucky","Gutsy","Meek"},
               {"Conviction","Enliven","Doubt","Remorseful"},
               {"Awe","Glory","Friendly","Praise"},
               {"Dull","Sleeky","Coarse","Smoothy"},
               {"Set","Alleviate","Bug","Bother"},
               {"Presage","Dignified","Hillarious","Worthy"},
               {"Cheer","Lift","Dissuade","Solace"},
               {"Face","Help","Meet","Outrun"},
               {"Free","Seed","Abduct","Shoot"},
               {"Delay","Pull","Slow","Impel"},
               {"Image","Reality","Match","Replica"},
               {"Conviction","Enliven","Lavish","Hitch"},
               {"Felicity","Ease","Revelry","Apathy"},
               {"Bevel","Sleeky","Carriage","Smoothy"},
               {"Galore","Liberal","Bug","Sparse"},
       };

       public String mCorrectAnswers[]={"Period","Cadastre","Envisage","Portrayal","Wisdom",
               "Desination","Provision","Nomenclature",
               "Equitable","Elevation","Disclosure","Adjoin",
               "Gracious","Adieu","Symposium","Accurate","Counsel",
               "Intention","Excerpt","Reed","Delegate","Naive","Upbraid",
               "Corny","Omit","Encourage","Benumb","Disdain",
               "Hesitant","Landlord","Abject","Original","Irreproachable",
               "Root","Lessen","Meek","Conviction","Friendly","Sleeky","Alleviate","Presage",
               "Dissuade","Outrun","Free","Impel","Reality","Hitch",
               "Apathy","Bevel","Sparse",
              };

       public String getQuestion(int a){

             String question =mQuestions[a];
             return question;

       }


    public String getChoice1(int a){

        String choice =mChoice[a][0];
        return choice;

    }
    public String getChoice2(int a){

        String choice =mChoice[a][1];
        return choice;

    }


    public String getChoice3(int a){

        String choice =mChoice[a][2];
        return choice;

    }

      public String getChoice4(int a){

        String choice =mChoice[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a){

        String answer =mCorrectAnswers[a];
        return answer;
    }



}
