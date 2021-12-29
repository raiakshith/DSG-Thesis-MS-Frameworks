module.exports = {
	name: "address",

	/**
	 * Actions
	 */
	actions: {

		/**
		 * Address of the customer
		 *
		 * @param {String} customerId 
		 */
		customer: {
			rest: "/customer",
			params: {
				customerId: "string"
			},
			/** @param {Context} ctx  */
			async handler(ctx) {
				return `Address of the customer, ${ctx.params.customerId}`;
			}
		}
	}
};