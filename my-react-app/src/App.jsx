import "./App.css";

import ProfileList from "./components/ProfileList";
import StepCounter from "./components/StepCounter";
import ProductInfo from "./components/ProductInfo";

function App() {
  return (
    <div className="app-container">
      <div className="app-container-inner">
        <h1>React Activity</h1>

        <h2>1. Profile List</h2>
        <div className="card">
          <div className="profile-grid">
            <ProfileList />
          </div>
        </div>

        <h2>2. Step Counter</h2>
        <div className="card">
          <div className="center-content">
            <div className="step-counter-wrapper">
              <StepCounter />
            </div>
          </div>
        </div>


        <h2>3. Product Info</h2>
        <div className="card">
          <div className="profile-grid">
            <ProductInfo
              name="Asus Tuf Gaming"
              price={49000}
              details="A fast laptop with 16GB RAM and 512GB SSD."
            />

            <ProductInfo
              name="Nitro V 15"
              price={46000}
              details="A fast laptop with 16GB RAM and 512GB SSD."
            />

          </div>
        </div>
      </div>
    </div>
  );
}

export default App;
