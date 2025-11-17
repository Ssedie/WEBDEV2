import { useState } from "react";

function ProductInfo({ name, price, details }) {
  const [showDetails, setShowDetails] = useState(false);

  return (
    <div>
      <p>Product: {name}</p>
      <p>Price: ₱{price}</p>

      <button className="btn" onClick={() => setShowDetails(!showDetails)}>
        {showDetails ? "Hide Details" : "Show Details"}
      </button>

      {showDetails && <p className="fade-in">{details}</p>}
    </div>
  );
}

export default ProductInfo;
