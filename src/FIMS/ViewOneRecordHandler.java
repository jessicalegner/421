package FIMS;

import domain.FacultyList;
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
		/*
		 * Populate the general tab
		 */
		frame.tab_gen_name.setText(fl.getRecord(selectedPerson).getName());
		frame.tab_gen_college.setText(fl.getRecord(selectedPerson).getCollege());
		frame.tab_gen_department.setText(fl.getRecord(selectedPerson)
				.getDepartment());
		frame.tab_gen_RAH.setText(fl.getRecord(selectedPerson).getRank()
				.getRankAtHire());
		frame.tab_gen_degree.setText(fl.getRecord(selectedPerson).getDegree()
				.getDegreeLevel());
		frame.tab_gen_comments.setText("Fix this");
		frame.tab_gen_gender.setText(String.valueOf(fl.getRecord(selectedPerson)
				.getGender()));
		frame.tab_gen_institution.setText(fl.getRecord(selectedPerson).getDegree()
				.getInstitution());

		/*
		 * Populate the evaluation tab
		 */
		frame.tab_eval_name.setText(fl.getRecord(selectedPerson).getName());
		if (!fl.getRecord(selectedPerson).getEvaluation().getYearOfEvaluations().isEmpty())
		{
			frame.tab_eval_1yr.setText(fl.getRecord(selectedPerson).getEvaluation()
					.getYearOfEvaluations().get(0).toString());
			frame.tab_eval_2yr.setText(fl.getRecord(selectedPerson).getEvaluation()
					.getYearOfEvaluations().get(1).toString());
			frame.tab_eval_4yr.setText(fl.getRecord(selectedPerson).getEvaluation()
					.getYearOfEvaluations().get(2).toString());
			frame.tab_eval_5yr.setText(fl.getRecord(selectedPerson).getEvaluation()
					.getYearOfEvaluations().get(3).toString());
		}
		else
		{
			frame.tab_eval_1yr.setText("");
			frame.tab_eval_2yr.setText("");
			frame.tab_eval_4yr.setText("");
			frame.tab_eval_5yr.setText("");
		}
		frame.tab_eval_tenure_granted.setText(fl.getRecord(selectedPerson)
				.getEvaluation().getYearTenureGranted());
		frame.tab_eval_doh.setText(fl.getRecord(selectedPerson).getDateOfHire());

		/*
		 * Populate the promotion tab
		 */
		frame.tab_promo_doh.setText(fl.getRecord(selectedPerson).getDateOfHire());
		frame.tab_promo_name.setText(fl.getRecord(selectedPerson).getName());
		frame.tab_promo_rank.setText(fl.getRecord(selectedPerson).getRank()
				.getCurrentRank());
		if (!fl.getRecord(selectedPerson).getPromotion().getYearOfPromotions().isEmpty())
		{
			frame.tab_promo_toasst.setText(fl.getRecord(selectedPerson).getPromotion()
					.getYearOfPromotions().get(0).toString());
			frame.tab_promo_toassoc.setText(fl.getRecord(selectedPerson).getPromotion()
					.getYearOfPromotions().get(1).toString());
			frame.tab_promo_toprof.setText(fl.getRecord(selectedPerson).getPromotion()
					.getYearOfPromotions().get(2).toString());
		}
		else
		{
			frame.tab_promo_toasst.setText("");
			frame.tab_promo_toassoc.setText("");
			frame.tab_promo_toprof.setText("");
		}

		/*
		 * Populate the sabbatical tab
		 */
		frame.tab_sab_eligible.setText("fix this");
		frame.tab_sab_name.setText(fl.getRecord(selectedPerson).getName());
		frame.tab_sab_doh.setText(fl.getRecord(selectedPerson).getDateOfHire());
	}
}
