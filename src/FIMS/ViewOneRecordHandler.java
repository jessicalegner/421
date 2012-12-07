package FIMS;

import domain.FacultyList;
import domain.FacultyMember;
import gui.GUI;

/**
 * Handler for viewing all records
 * 
 */
public class ViewOneRecordHandler
{
  /**
   * View all records. Get all records from the datastore, pass them back to GUI
   * to populate the list
   * 
   * @param frame
   */
  public void viewOne(GUI frame, int selectedPerson, FacultyList fl)
  {
    FacultyMember fm = new FacultyMember();
    fm = fl.getRecord(selectedPerson);

    String name = fm.getName();
    String doh = fm.getDateOfHire();
    /*
     * Populate the general tab
     */
    frame.tab_gen_name.setText(name);
    frame.tab_gen_college.setText(fm.getCollege());
    frame.tab_gen_department.setText(fm.getDepartment());
    frame.tab_gen_RAH.setText(fm.getRank().getRankAtHire());
    frame.tab_gen_degree.setText(fm.getDegree().getDegreeLevel());
    frame.tab_gen_institution.setText(fm.getDegree().getInstitution());
    frame.tab_gen_comments.setText(fm.getComments().get(1));
    frame.tab_gen_gender.setText(String.valueOf(fm.getGender()));

    /*
     * Populate the evaluation tab
     */
    frame.tab_eval_name.setText(name);
    if (!fm.getEvaluation().getYearOfEvaluations().isEmpty())
    {
      frame.tab_eval_1yr.setText(fm.getEvaluation().getYearOfEvaluations()
          .get(0).toString());
      frame.tab_eval_2yr.setText(fm.getEvaluation().getYearOfEvaluations()
          .get(1).toString());
      frame.tab_eval_4yr.setText(fm.getEvaluation().getYearOfEvaluations()
          .get(2).toString());
      frame.tab_eval_5yr.setText(fm.getEvaluation().getYearOfEvaluations()
          .get(3).toString());
    } else
    {
      frame.tab_eval_1yr.setText("");
      frame.tab_eval_2yr.setText("");
      frame.tab_eval_4yr.setText("");
      frame.tab_eval_5yr.setText("");
    }
    frame.tab_eval_tenure_granted.setText(fm.getEvaluation()
        .getYearTenureGranted());
    frame.tab_eval_doh.setText(doh);

    /*
     * Populate the promotion tab
     */
    frame.tab_promo_doh.setText(doh);
    frame.tab_promo_name.setText(name);
    frame.tab_promo_rank.setText(fm.getRank().getCurrentRank());
    if (!fm.getPromotion().getYearOfPromotions().isEmpty())
    {
      frame.tab_promo_toasst.setText(fm.getPromotion().getYearOfPromotions()
          .get(0).toString());
      frame.tab_promo_toassoc.setText(fm.getPromotion().getYearOfPromotions()
          .get(1).toString());
      frame.tab_promo_toprof.setText(fm.getPromotion().getYearOfPromotions()
          .get(2).toString());
    } else
    {
      frame.tab_promo_toasst.setText("");
      frame.tab_promo_toassoc.setText("");
      frame.tab_promo_toprof.setText("");
    }

    /*
     * Populate the sabbatical tab
     */
    frame.tab_sab_eligible.setText("");
    frame.tab_sab_name.setText(name);
    frame.tab_sab_doh.setText(doh);
  }
}
