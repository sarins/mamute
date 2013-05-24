package br.com.caelum.brutal.model;

import br.com.caelum.brutal.reputation.rules.KarmaCalculator;
import br.com.caelum.brutal.reputation.rules.KarmaRewardEvent;

public enum EventType implements KarmaRewardEvent {
	
	QUESTION_UPVOTE {
		@Override
		public int reward() {
			return KarmaCalculator.MY_QUESTION_VOTED_UP;
		}
	}, 
	
	
	QUESTION_DOWNVOTE {
		@Override
		public int reward() {
			return KarmaCalculator.MY_QUESTION_VOTED_DOWN;
		}
	}, 
	
	ANSWER_UPVOTE {
		@Override
		public int reward() {
			return KarmaCalculator.MY_ANSWER_VOTED_UP;
		}
	},
	
	ANSWER_DOWNVOTE {
		@Override
		public int reward() {
			return KarmaCalculator.MY_ANSWER_VOTED_DOWN;
		}
	}, 
	
	COMMENT_UPVOTE {
		@Override
		public int reward() {
			return KarmaCalculator.COMMENT_VOTED_UP;
		}
	}, 
	
	EDIT_APPROVED {
		@Override
		public int reward() {
			return KarmaCalculator.APPROVED_INFORMATION;
		}
	}, 
	
	CREATED_ANSWER {
		@Override
		public int reward() {
			return KarmaCalculator.ASKED_QUESTION;
		}
	}, 
	
	CREATED_QUESTION {
		@Override
		public int reward() {
			return KarmaCalculator.ANSWERED_QUESTION;
		}
	}, 
	DOWNVOTED_SOMETHING {
		@Override
		public int reward() {
			return KarmaCalculator.DOWNVOTED_QUESTION_OR_ANSWER;
		}
	}, 
	IGNORED {
		@Override
		public int reward() {
			return 0;
		}
	}, 
	SOLVED_QUESTION {
		@Override
		public int reward() {
			return KarmaCalculator.SOLUTION_AUTHOR;
		}
	}, 
	MARKED_SOLUTION {
		@Override
		public int reward() {
			return KarmaCalculator.SOLVED_QUESTION_AUTHOR;
		}
	};

	public abstract int reward();
	

}