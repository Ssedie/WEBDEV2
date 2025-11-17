import { useState } from "react";

function StepCounter() {
  const [count, setCount] = useState(0);
  const [step, setStep] = useState(1);

  return (
    <div>
      <p>Count: {count}</p>

      <input
        type="number"
        placeholder="Enter step value"
        value={step}
        onChange={(e) => setStep(Number(e.target.value))}
      />

      <button className="btn" onClick={() => setCount(count + step)}>
        Add
      </button>
    </div>
  );
}

export default StepCounter;
