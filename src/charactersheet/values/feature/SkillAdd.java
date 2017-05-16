package charactersheet.values.feature;

import charactersheet.values.Skill;

public class SkillAdd implements Addition {

	public final Skill skill;

	public SkillAdd(final Skill skill) {
		this.skill = skill;
	}

	@Override
	public Object getProperty() {
		return skill;
	}

	@Override
	public Object getChange() {
		return skill;
	}

}
