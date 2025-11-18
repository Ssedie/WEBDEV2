import ProfileCard from "./ProfileCard";

function ProfileList() {
  return (
    <div className="profile-grid">
      <ProfileCard name="Zed" age={22} role="Developer" />
      <ProfileCard name="Rhayven" age={20} role="Designer" />
      <ProfileCard name="Ulysses" age={20} role="Project Manager" />
      <ProfileCard name="Roineill" age={20} role="CEO" />
    </div>
  );
}

export default ProfileList;
